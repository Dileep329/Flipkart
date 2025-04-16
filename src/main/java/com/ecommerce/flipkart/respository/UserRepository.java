package com.ecommerce.flipkart.respository;

import com.ecommerce.flipkart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);
}
