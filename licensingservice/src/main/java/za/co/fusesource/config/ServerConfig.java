package za.co.fusesource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/07/28.
 */
@Component
public class ServerConfig {

    @Value("${comment}")
    private String comment;

    public String getComment() {
        return comment;
    }

}
