package za.co.fnb.fusesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/29.
 */
@SpringBootApplication
@EnableEurekaClient
public class OrganizationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationBootstrap.class, args);
    }
}
