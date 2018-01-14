package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.mstorderservice.entity.ShoppingCartGoods;

import java.util.List;

public class ShoppingCartDTO {
    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("shopping_cart_goods")
    private List<ShoppingCartGoods> shoppingCartGoods;
}
