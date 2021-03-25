package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commons.Customer;
import com.example.demo.commons.DataStore;
import com.example.demo.commons.Product;
import com.example.demo.dto.CustomerDto;
import com.example.demo.feign.client.ProductClient;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable String id){
        Customer customer = DataStore.listCustomers().stream().filter(cust -> cust.getId().equalsIgnoreCase(id)).findFirst().get();
        List<Product> products = productClient.listProductsByCustomerId(id);
        CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(customer, dto);
        dto.setProducts(products);
        //Product pr1 = productClient.getProductById("PRD1");
        //Product pr2 = productClient.create(products.get(0));
        //List<Product> pr3 = productClient.listProducts();
        return dto;
    }

}
