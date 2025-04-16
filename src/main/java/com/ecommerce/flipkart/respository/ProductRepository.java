package com.ecommerce.flipkart.respository;

import com.ecommerce.flipkart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
