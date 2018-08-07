package za.co.fusesource.model;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/29.
 */
public class Organization {

    private String organizationId;
    private String organizationName;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId='" + organizationId + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
