package com.javalife.microservices.product.dto;
// You can use REcord or Lombok

// Record is immutable

// Lombok is a library that provides annotations for generating boilerplate code

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
}*/

public record ProductResponse(String id, String name, String description, String category, double price,
                              String imageUrl) {
}
