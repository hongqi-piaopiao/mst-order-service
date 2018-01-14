package com.thoughtworks.mstorderservice.controller;

import com.thoughtworks.mstorderservice.dto.GoodAdditionDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCart;
import com.thoughtworks.mstorderservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingCart addShoppingCart(@RequestBody GoodAdditionDTO goodAdditionDTO) {
        return shoppingCartService.addShoppingCartGood(goodAdditionDTO);
    }
}
