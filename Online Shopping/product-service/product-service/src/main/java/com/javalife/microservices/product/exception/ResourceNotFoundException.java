package com.javalife.microservices.product.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException (String message) {
        super(message);
    }
}
