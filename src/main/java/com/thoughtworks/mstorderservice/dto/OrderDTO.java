package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {


    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("order_goods")
    private List<OrderGoodsDTO> orderGoodsDTOList;

    @JsonProperty("is_paid")
    private boolean paid;

    @JsonProperty("price")
    private int priceAmount;
}
