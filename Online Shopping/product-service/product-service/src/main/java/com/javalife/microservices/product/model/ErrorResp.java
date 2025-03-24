package com.javalife.microservices.product.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResp {
    private String message;
    private String status;
    private String code;
    private String error;
    private LocalDateTime timestamp;


    public ErrorResp(String message, String failure, String number, String duplicateProduct, LocalDateTime now) {
    }

    public ErrorResp() {

    }
}



