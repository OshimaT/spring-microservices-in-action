package za.co.fusesource.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/23.
 */
@Entity
@Table(name="licenses")
public class License {

    @Id
    @Column(name="license_id", nullable = false)
    private String licenseId ;

    @Column(name="organization_id", nullable=false)
    private String organizationId;

    @Column(name="production_name", nullable = false)
    private String productName ;

   // private String licenseType = "Seat";

    //private String comment;

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseId='" + licenseId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

    //    public String getLicenseType() {
//        return licenseType;
//    }
//
//    public void setLicenseType(String licenseType) {
//        this.licenseType = licenseType;
//    }
//
////    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
}
