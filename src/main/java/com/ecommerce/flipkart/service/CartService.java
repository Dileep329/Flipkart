package com.ecommerce.flipkart.service;

import com.ecommerce.flipkart.payload.CartDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();

    CartDTO getCart(String emailId, Long cartId);

    @Transactional
    CartDTO updateProductQuantityInCart(Long productId, Integer quantity);

    @Transactional
    String deleteProductFromCart(Long cartId, Long productId);

    void updateProductInCarts(Long cartId, Long productId);
}
