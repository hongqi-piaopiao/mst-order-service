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
@Table(name = "t_order")
@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<OrderGoods> orderGoods;

    @Column(name = "price")
    private int priceAmount;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "is_paid")
    private boolean paid;
}
