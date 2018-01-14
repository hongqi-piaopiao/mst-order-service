package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "t_shopping_cart_goods")
@Entity
public class ShoppingCartGoods {
    @Id
    private String id;

    @Column(name="good_id")
    private String goodId;

    @Column(name="shopping_cart_id")
    private String shoppingCartId;


    @Column(name="quantity")
    private long quantity;

}
