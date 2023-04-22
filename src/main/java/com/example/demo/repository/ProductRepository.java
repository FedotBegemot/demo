package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component("Product")
public interface ProductRepository extends MongoRepository<Product, String> {

    public Product findByName(String name);
    public List<Product> findAll();
    public List<Product> findAllByType(String type);

}
