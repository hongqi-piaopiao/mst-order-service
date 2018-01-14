package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.ShoppingCartGoods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartGoodsRepository extends JpaRepository<ShoppingCartGoods,String> {
}
