package za.co.fusesource.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.fusesource.config.ServerConfig;
import za.co.fusesource.licenses.OrganizationDiscoveryClient;
import za.co.fusesource.licenses.OrganizationFeignClient;
import za.co.fusesource.licenses.OrganizationRestTemplateClient;
import za.co.fusesource.model.License;
import za.co.fusesource.model.Organization;
import za.co.fusesource.services.LIcenseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/28.
 */
@Service
public class LicenseService {

    private Logger logger = LoggerFactory.getLogger(za.co.fusesource.service.LicenseService.class);
    @Autowired
    private LIcenseRepository lIcenseRepository;

    @Autowired
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    @Autowired
    private OrganizationRestTemplateClient organizationRestTemplateClient;

    @Autowired
    private ServerConfig serverConfig;

    //@Autowired
    //private OrganizationFeignClient organizationFeignClient;

    public License getLicense(String organizationId, String licenseId) {

        License license = lIcenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        System.out.println(license);
        System.out.println(serverConfig.getComment());
        return license;
    }

    public License getLicenseWithClientType(String organizationId, String licenseId, String clientType) {

        License license = lIcenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        System.out.println(license);
        System.out.println(serverConfig.getComment());
        Organization organization = null;
        if ("discoveryClient".equalsIgnoreCase(clientType)) {
            logger.info(">>>>>>>>>>>>> Calling the Rest Endpoint through Discovery Client >>>>>>>>>>>>>");
            organization = organizationDiscoveryClient.getOrganization(organizationId);
            logger.info(organization.toString());
            logger.info(">>>>>>>>>>>>> End Calling the Rest Endpoint through Discovery Client >>>>>>>>>>>>>");

        }else if ("ribbon".equalsIgnoreCase(clientType)) {
            logger.info(">>>>>>>>>>>>> Calling the Rest Endpoint through RestTemplate >>>>>>>>>>>>>");
            organization = organizationRestTemplateClient.getOrganization(organizationId);
            logger.info(organization.toString());
            logger.info(">>>>>>>>>>>>> End Calling the Rest Endpoint through RestTemplate >>>>>>>>>>>>>");


        }else {
            logger.info(">>>>>>>>>>>>> Calling the Rest Endpoint through Feign client >>>>>>>>>>>>>");
           // organization = organizationFeignClient.getOrganization(organizationId);
            logger.info(organization.toString());
            logger.info(">>>>>>>>>>>>> End Calling the Rest Endpoint through Feign client>>>>>>>>>>>>>");

        }
        return null;
    }

    @HystrixCommand(fallbackMethod = "buildFallbackLicense",
                    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                          value = "900")},
                    threadPoolKey = "licenseByOrgThreadPool",
                    threadPoolProperties = {
                                            @HystrixProperty(name = "coreSize", value = "30"),
                                            @HystrixProperty(name = "maxQueueSize", value = "10")
                    })
    public List<License> getLicenseByOrg(String organizationId) {

        randomRunLong();
        return lIcenseRepository.findByOrganizationId(organizationId);

    }

    private List<License> buildFallbackLicense(String organizationId) {

        List<License> licenses = new ArrayList<>();
        logger.info("Inside the fallback logic >>>>>>>>>>>>>>>>>>>>>>>>> ");
         License license = new License();
         license.setLicenseId(UUID.randomUUID().toString());
         license.setOrganizationId(UUID.randomUUID().toString());
         license.setProductName("Hololo");
         licenses.add(license);
         return licenses;

    }

    private void randomRunLong() {

        Random random = new Random();
        int randomNum = random.nextInt( (3 - 1)+ 1)+1;
        if (randomNum == 3) sleep();
    }

    private void sleep() {

        try {
            Thread.sleep(1100);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
    }

    public Organization retrieveOrgInfo(String organizationId, String clientTYpe) {
        return null;
    }

}
