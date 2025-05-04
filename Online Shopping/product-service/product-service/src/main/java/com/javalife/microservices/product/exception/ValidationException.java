package com.javalife.microservices.product.exception;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
