package za.co.fusesource.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.fusesource.model.License;
import za.co.fusesource.service.LicenseService;

import java.util.List;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/23.
 */
@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public License getLiceense(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return licenseService.getLicense(organizationId, licenseId);
    }


    @RequestMapping(value = "/{licenseId}/{clientType}", method = RequestMethod.GET)
    public License getLicenseWithClientType(@PathVariable("organizationId") String organizationId,
                                            @PathVariable("licenseId") String licenseId,
                                            @PathVariable("clientType") String clientType) {

        return licenseService.getLicenseWithClientType(organizationId, licenseId, clientType);

    }

    @RequestMapping(value= "/byOrg")
    public List<License> findByOrganizationId(@PathVariable("organizationId") String organizationId) {

        return licenseService.getLicenseByOrg(organizationId);
    }

}
