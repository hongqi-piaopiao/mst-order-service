package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem,Integer> {

}
