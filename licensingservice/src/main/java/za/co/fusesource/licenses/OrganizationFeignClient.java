package za.co.fusesource.licenses;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.fusesource.model.Organization;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/31.
 */
//@FeignClient("organizationservice")
//@Component
public interface OrganizationFeignClient {

  //  @RequestMapping(method = RequestMethod.GET,
    //                value = "v1/organizations/{organizationId}",
      //              consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
