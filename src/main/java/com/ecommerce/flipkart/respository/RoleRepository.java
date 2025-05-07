package com.ecommerce.flipkart.respository;

import com.ecommerce.flipkart.models.AppRole;
import com.ecommerce.flipkart.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
