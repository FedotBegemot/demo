package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

@RestController
//@Component("ProductRepository")
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/newproduct")
    public void addProducts(Product product) {
        productRepository.insert(product);
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

//    @GetMapping("/{type}")
//    public List<Product> findAllByType(@PathVariable final String type) {
//        return productRepository.findAllByType(type);
//    }
}