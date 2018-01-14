package com.thoughtworks.mstorderservice.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "t_shopping_cart")
@Entity
public class ShoppingCart {
    @Id
    private String id;

    @Column(name="user_id")
    private String userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "shopping_cart_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<ShoppingCartGoods> shoppingCartGoods;
}
