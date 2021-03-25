package com.example.demo.dto;

import java.util.List;

import com.example.demo.commons.Customer;
import com.example.demo.commons.Product;

public class CustomerDto extends Customer {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
