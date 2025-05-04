package com.javalife.microservices.product.exception;

public class DatabaseException extends Exception {
    public DatabaseException (String message) {
        super(message);
    }
}
