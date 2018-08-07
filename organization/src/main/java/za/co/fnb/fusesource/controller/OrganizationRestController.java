package za.co.fnb.fusesource.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.fnb.fusesource.model.Organization;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/29.
 */
@RestController
@RequestMapping(value="v1/organizations/")
public class OrganizationRestController {


    @RequestMapping(value = "/{organizationId}")
    public Organization getOrganization(@PathVariable("organizationId") String organizationId) {

        Organization organization = new Organization();
        organization.setId(organizationId);
        organization.setOrganizationName("Redhat");

        return organization;
    }
}
