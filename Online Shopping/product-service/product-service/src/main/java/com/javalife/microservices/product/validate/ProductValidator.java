package com.javalife.microservices.product.validate;

import com.javalife.microservices.product.dto.ProductRequest;
import com.javalife.microservices.product.model.ErrorResp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductValidator {

    public ErrorResp ValidateRequest(List<ProductRequest> productRequests) {
        ErrorResp error = new ErrorResp();

        for (ProductRequest productRequest : productRequests) {
            if (productRequest.description() == null || productRequest.description().isEmpty()) {
                error.setMessage("Description is required");
                error.setStatus("400");
                error.setCode("Invalid Request");
                error.setError("Bad Request");
            }
            if (productRequest.name() == null || productRequest.name().isEmpty()) {
                error.setMessage("Name is required");
                error.setStatus("400");
                error.setCode("Invalid Request");
                error.setError("Bad Request");
            }
            if (productRequest.category() == null || productRequest.category().isEmpty()) {
                error.setMessage("Category is required");
                error.setStatus("400");
                error.setCode("Invalid Request");
                error.setError("Bad Request");

            }
            if (productRequest.price() <= 0) {
                error.setMessage("Price must be greater than 0");
                error.setStatus("400");
                error.setCode("Invalid Request");
                error.setError("Bad Request");
            }
            if (productRequest.imageUrl() == null || productRequest.imageUrl().isEmpty()) {
                error.setMessage("Image URL is required");
                error.setStatus("400");
                error.setCode("Invalid Request");
                error.setError("Bad Request");
            }
        }
        return error;
    }
}
