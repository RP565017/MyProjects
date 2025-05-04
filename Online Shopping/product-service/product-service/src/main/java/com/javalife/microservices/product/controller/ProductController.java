package com.javalife.microservices.product.controller;

import com.javalife.microservices.product.dto.ProductRequest;
import com.javalife.microservices.product.dto.ProductResponse;
import com.javalife.microservices.product.exception.DatabaseException;
import com.javalife.microservices.product.exception.DuplicateProductException;
import com.javalife.microservices.product.exception.ResourceNotFoundException;
import com.javalife.microservices.product.exception.ValidationException;
import com.javalife.microservices.product.model.ErrorResp;
import com.javalife.microservices.product.service.ProductService;
import com.javalife.microservices.product.validate.ProductValidator;
import com.mongodb.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final ProductValidator productValidator;

    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> createProduct(@RequestBody List<ProductRequest> productRequest) {


        try {
            ErrorResp error = productValidator.ValidateRequest(productRequest);

            if (error.getMessage() != null) {
              //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
                throw new ValidationException(error.getMessage());
            } else {
                List<ProductResponse> productResponse = productService.createProduct(productRequest);
                LOGGER.info("Product {} is saved", productResponse);
                return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
            }
        } catch (DuplicateKeyException e){
            LOGGER.error("Duplicate Product: ", e);
            throw new RuntimeException("Product with the same key already exists.");
        } catch (UncategorizedMongoDbException e) {
            LOGGER.error("Mongo error: ", e);
            throw new RuntimeException("Unexpected database error occurred.");
        }catch (Exception e) {
            LOGGER.error("Unexpected error: ", e);
            throw new RuntimeException(e);  // handled by global handler

        }
}

@PutMapping(value = "/update")
public ResponseEntity<Object> updateProduct(@RequestBody ProductRequest productRequest) {

    try {
        productService.updateProduct(productRequest);

            LOGGER.info("Product updated successfully");
            return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully");


        } catch (Exception e) {
        LOGGER.error("Product update failed: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
        }
    }


@DeleteMapping(value = "/delete/{id}")
public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
    try {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid product ID");
        }
        productService.deleteProduct(id);
        LOGGER.info("Product with Id {} deleted successfully", id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
        LOGGER.error("Product deletion failed: ", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deletion failed");
    }
}

@DeleteMapping(value = "/delete/by-name/{name}")
public ResponseEntity<Object> deleteProductByName(@PathVariable String name) {
    try {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid product name");
        }
        productService.deleteProductByName(name);
        LOGGER.info("Product with Name {} deleted successfully", name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
        LOGGER.error("Product deletion failed: ", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deletion failed");
    }
}

@GetMapping(value = "/all", produces = "application/json")
public ResponseEntity<Object> getAllProducts() {
    try {
        List<ProductResponse> list = productService.getAllProducts();
        LOGGER.info("Retrieved {} products", list.size());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    } catch (Exception e) {
        LOGGER.error("No records found: ", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
}


}