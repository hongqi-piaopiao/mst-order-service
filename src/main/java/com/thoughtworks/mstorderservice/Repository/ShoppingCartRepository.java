package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String>{
    ShoppingCart findByUserId(String userId);
}
