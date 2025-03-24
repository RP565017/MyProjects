package com.javalife.microservices.product.dto;


public record ProductRequest(String id, String name, String description, String category, double price,
                             String imageUrl) {
}
