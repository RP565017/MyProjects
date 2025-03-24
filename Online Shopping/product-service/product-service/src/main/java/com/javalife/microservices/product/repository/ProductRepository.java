package com.javalife.microservices.product.repository;

import com.javalife.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ProductRepository extends MongoRepository<Product, String> {

    void deleteByName(String name);

    Optional<Product> findByName(String name);
}
