package rospopa.strpz2client.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URI;

@Data
@Validated
@ConfigurationProperties("application.integration.product-service")
public class ProductServiceIntegrationProperties {

    @NotNull
    private URI productsUrl;
}
