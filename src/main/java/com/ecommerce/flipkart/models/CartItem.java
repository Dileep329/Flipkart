package com.ecommerce.flipkart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne

    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id")
//    @JoinTable(
//            name = "cartItem_cart",
//            joinColumns = @JoinColumn(name = "cartItemId"),
//            inverseJoinColumns = @JoinColumn(name = "cartId")
//    )
    private Product product;

    private Integer quantity;
    private double discount;
    private double productPrice;
}
