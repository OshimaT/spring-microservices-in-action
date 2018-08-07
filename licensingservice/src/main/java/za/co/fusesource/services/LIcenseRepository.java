package za.co.fusesource.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.fusesource.model.License;

import java.util.List;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/28.
 */
@Repository
public interface LIcenseRepository extends CrudRepository<License, String> {

    public List<License> findByOrganizationId(String organizationId);
    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

}
