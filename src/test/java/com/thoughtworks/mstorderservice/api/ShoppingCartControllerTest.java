package com.thoughtworks.mstorderservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.mstorderservice.Repository.ShoppingCartGoodsRepository;
import com.thoughtworks.mstorderservice.Repository.ShoppingCartRepository;
import com.thoughtworks.mstorderservice.dto.GoodAdditionDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCart;
import com.thoughtworks.mstorderservice.entity.ShoppingCartGoods;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShoppingCartControllerTest extends BaseControllerTest {
    @Autowired
    private ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    void should_return_good_when_give_good_id() throws Exception {
        String good1Id = "1";
        String good2Id = "2";
        String good3Id = "3";
        ShoppingCartGoods shoppingCartGood1 = ShoppingCartGoods.builder()
                                                               .id("1")
                                                               .goodId(good1Id)
                                                               .quantity(20L)
                                                               .shoppingCartId("1")
                                                               .build();
        ShoppingCartGoods shoppingCartGood2 = ShoppingCartGoods.builder()
                                                               .id("2")
                                                               .goodId(good2Id)
                                                               .quantity(15L)
                                                               .shoppingCartId("1")
                                                               .build();

        GoodAdditionDTO goodAdditionDTO=GoodAdditionDTO.builder().goodId(good3Id).userId("12").quantity(23L).build();

        shoppingCartGoodsRepository.save(shoppingCartGood1);
        shoppingCartGoodsRepository.save(shoppingCartGood2);

        List<ShoppingCartGoods> shoppingCartGoodsList = Arrays.asList(shoppingCartGood1, shoppingCartGood2);
        ShoppingCart shoppingCart = ShoppingCart.builder()
                                                .id("1")
                                                .shoppingCartGoods(shoppingCartGoodsList)
                                                .userId("12")
                                                .build();
        shoppingCartRepository.save(shoppingCart);


        mockMvc.perform(post("/api/shoppingCart")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(new ObjectMapper().writeValueAsString(goodAdditionDTO)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.userId").value("12"));
    }
}
