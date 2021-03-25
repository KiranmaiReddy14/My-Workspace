package com.example.demo.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.commons.Product;


@FeignClient(name="product-service")
public interface ProductClient {

    @GetMapping("/products")
    List<Product> listProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable String id);

    @PostMapping("/products")
    Product create(@RequestBody Product product);

    @GetMapping("/products/customer/{custId}")
    List<Product> listProductsByCustomerId(@PathVariable String custId);
}
