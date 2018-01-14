package com.thoughtworks.mstorderservice.service;


import com.thoughtworks.mstorderservice.dto.GoodAdditionDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addShoppingCartGood(GoodAdditionDTO goodAdditionDTO);
}
