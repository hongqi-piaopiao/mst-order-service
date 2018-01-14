package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_shopping_item")
@Entity
public class ShoppingItem {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="goods_id")
    private int goodsId;
}
