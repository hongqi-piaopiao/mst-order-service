package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsDTO {

    private int id;

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("goods_id")
    private int goodsId;
}
