package za.co.fusesource.licenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.co.fusesource.model.Organization;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/31.
 */
@Component
public class OrganizationRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    public Organization getOrganization(String organizationId) {

        ResponseEntity<Organization> restExchange =
                restTemplate.exchange("http://organizationservice/v1/organizations/{organizationId}",
                        HttpMethod.GET, null, Organization.class, organizationId );
        return restExchange.getBody();

    }
}
