package com.ecommerce.flipkart.controllers;

import com.ecommerce.flipkart.models.Cart;
import com.ecommerce.flipkart.payload.CartDTO;
import com.ecommerce.flipkart.respository.CartItemRepository;
import com.ecommerce.flipkart.respository.CartRepository;
import com.ecommerce.flipkart.service.CartService;
import com.ecommerce.flipkart.util.AuthUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/carts/products/{productId}/quatity")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long productId,
                                                    @PathVariable Integer quantity) {
        CartDTO cartDTO = cartService.addProductToCart(productId, quantity);
        return new ResponseEntity<>(cartDTO, HttpStatus.CREATED);
    }

        @GetMapping("/carts")
        public ResponseEntity<List<CartDTO>> getCarts() {
            List<CartDTO> cartDTOs = cartService.getAllCarts();
            return new ResponseEntity<List<CartDTO>>(cartDTOs, HttpStatus.FOUND);
        }

        @GetMapping("/carts/users/cart")
        public ResponseEntity<CartDTO> getCartById () {
            String emailId = authUtil.loggedInEmail();
            Cart cart = cartRepository.findCartByEmail(emailId);
            Long cartId = cart.getCartId();
            CartDTO cartDTO1 = cartService.getCart(emailId, cartId);
            return new ResponseEntity<CartDTO>(cartDTO1, HttpStatus.OK);
        }

        @PutMapping("/cart/products/{productId}/quantity/{operation}")
        public ResponseEntity<CartDTO> updateCartProduct (@PathVariable Long productId,
                @PathVariable String operation){

            CartDTO cartDTO = cartService.updateProductQuantityInCart(productId,
                    operation.equalsIgnoreCase("delete") ? -1 : 1);

            return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
        }

        @DeleteMapping("/carts/{cartId}/product/{productId}")
        public ResponseEntity<String> deleteProductFromCart (@PathVariable Long cartId,
                @PathVariable Long productId){
            String status = cartService.deleteProductFromCart(cartId, productId);

            return new ResponseEntity<String>(status, HttpStatus.OK);
        }
    }
