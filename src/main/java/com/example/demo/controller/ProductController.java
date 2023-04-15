package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(path ="/newproduct")
    public void addProducts(String products) {
//        productRepository.saveAll(products);
        System.out.println("abc");
    }

    @GetMapping("/allproducts")
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{name}")
    public Product findProduct(@PathVariable final String name) {
        return productRepository.findByName(name);
    }

    @GetMapping("/{type}")
    public List<Product> findAllOfType(@PathVariable final String type) {
        return productRepository.findAllOfType(type);
    }
}