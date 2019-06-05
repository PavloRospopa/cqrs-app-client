package rospopa.strpz2client.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import rospopa.strpz2client.configuration.ProductServiceIntegrationProperties;
import rospopa.strpz2client.web.dto.ProductDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceClient {
    private final ProductServiceIntegrationProperties integrationProperties;
    private final RestTemplate restTemplate;

    @Cacheable(cacheNames = "products")
    public List<ProductDto> getProducts() {
        try {
            log.debug("Issuing request to get list of products from product-service");
            return restTemplate.exchange(integrationProperties.getProductsUrl(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<ProductDto>>() {
                    })
                    .getBody();
        } catch (RestClientException e) {
            log.error("Failed to get list of products!", e);
            throw e;
        }
    }
}
