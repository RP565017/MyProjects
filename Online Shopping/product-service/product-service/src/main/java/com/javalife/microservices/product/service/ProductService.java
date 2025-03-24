package com.javalife.microservices.product.service;


import com.javalife.microservices.product.dto.ProductRequest;
import com.javalife.microservices.product.dto.ProductResponse;
import com.javalife.microservices.product.model.Product;
import com.javalife.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public List<ProductResponse> createProduct(List<ProductRequest> productRequests) {

        List<ProductResponse> responses = new ArrayList<>();

        for (ProductRequest productRequest : productRequests) {
            Product product = Product.builder()
                    .name(productRequest.name())
                    .description(productRequest.description())
                    .category(productRequest.category())
                    .price(productRequest.price())
                    .imageUrl(productRequest.imageUrl())
                    .build();

            productRepository.save(product);

            LOGGER.info("Product {} is saved", product.getId());

            ProductResponse response = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getPrice(),
                    product.getImageUrl()
            );
            responses.add(response);
        }
        return responses;
    }

    public ResponseEntity<Product> updateProduct(ProductRequest productRequest) {

        Optional<Product> optionalProduct = productRepository.findByName(productRequest.name());

        if (optionalProduct.isEmpty()) {
            LOGGER.warn("Product with name {} not found", productRequest.name());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Product product = optionalProduct.get();
        product.setDescription(productRequest.description());
        product.setCategory(productRequest.category());
        product.setPrice(productRequest.price());
        product.setImageUrl(productRequest.imageUrl());

        // 3. Save updated product
        productRepository.save(product);
        LOGGER.info("Product with name {} updated successfully", product.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }



    public void deleteProduct(String id) {

        productRepository.deleteById(id);

        LOGGER.info("Product with ID {} deleted successfully", id);
    }

    public void deleteProductByName(String name) {

        productRepository.deleteByName(name);

        LOGGER.info("Product with Name {} deleted successfully", name);
    }


    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),
                        product.getDescription(), product.getCategory(), product.getPrice(),
                        product.getImageUrl()))
                .collect(Collectors.toList());  // Collect into a list

        LOGGER.info("Retrieved {} products", productResponses.size());
        return productResponses;
    }
}


