package rospopa.strpz2client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rospopa.strpz2client.client.ProductServiceClient;
import rospopa.strpz2client.web.dto.ProductDto;

import java.util.List;

import static rospopa.strpz2client.web.controller.ProductController.ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping(ENDPOINT)
class ProductController {
    static final String ENDPOINT = "/products";

    private final ProductServiceClient productServiceClient;

    @GetMapping
    List<ProductDto> getProducts() {
        return productServiceClient.getProducts();
    }
}
