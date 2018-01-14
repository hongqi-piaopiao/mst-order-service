package com.thoughtworks.mstorderservice.service.impl;

import com.thoughtworks.mstorderservice.Repository.ShoppingCartGoodsRepository;
import com.thoughtworks.mstorderservice.Repository.ShoppingCartRepository;
import com.thoughtworks.mstorderservice.dto.GoodAdditionDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCart;
import com.thoughtworks.mstorderservice.entity.ShoppingCartGoods;
import com.thoughtworks.mstorderservice.service.ShoppingCartService;
import com.thoughtworks.mstorderservice.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Override
    public ShoppingCart addShoppingCartGood(GoodAdditionDTO goodAdditionDTO) {
        String userId=goodAdditionDTO.getUserId();
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);

        ShoppingCartGoods shoppingCartGoods=ShoppingCartGoods
                .builder()
                .id(StringUtils.uuid())
                .goodId(goodAdditionDTO.getGoodId())
                .quantity(goodAdditionDTO.getQuantity())
                .build();

        shoppingCart.getShoppingCartGoods().add(shoppingCartGoods);

        shoppingCartGoodsRepository.save(shoppingCartGoods);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }
}
