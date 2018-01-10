package com.thoughtworks.mstorderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_order_goods")
@Entity
public class OrderGoods {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="order_id")
    private int orderId;

    @Column(name="goods_id")
    private int goodsId;
}
