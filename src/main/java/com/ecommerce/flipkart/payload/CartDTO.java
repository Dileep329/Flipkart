package com.ecommerce.flipkart.payload;

import com.ecommerce.flipkart.models.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long CartId;
    private Double totalPrice=0.0;
    private List<ProductDTO> products=new ArrayList<>();
}
