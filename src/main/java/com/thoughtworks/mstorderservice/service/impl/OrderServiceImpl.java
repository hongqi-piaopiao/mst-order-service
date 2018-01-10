package com.thoughtworks.mstorderservice.service.impl;

import com.thoughtworks.mstorderservice.Repository.OrderRepository;
import com.thoughtworks.mstorderservice.dto.OrderDTO;
import com.thoughtworks.mstorderservice.dto.OrderGoodsDTO;
import com.thoughtworks.mstorderservice.entity.Order;
import com.thoughtworks.mstorderservice.entity.OrderGoods;
import com.thoughtworks.mstorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(fromDTO(orderDTO));
        return fromEntity(order);
    }

    @Override
    public OrderDTO payOrder(int orderId) {
        return null;
    }


    private Order fromDTO(OrderDTO orderDTO) {
        Order order = Order.builder().paid(orderDTO.isPaid()).priceAmount(orderDTO.getPriceAmount()).userId(orderDTO.getUserId()).build();

        if (!CollectionUtils.isEmpty(orderDTO.getOrderGoodsDTOList())) {
            order.setOrderGoods(orderDTO.getOrderGoodsDTOList().stream().map(orderGoodsDTO ->
                    OrderGoods.builder().goodsId(orderGoodsDTO.getGoodsId()).build()).collect(Collectors.toList()));
        }
        return order;
    }


    private OrderDTO fromEntity(Order order) {
        OrderDTO orderDTO = OrderDTO.builder().id(order.getId()).paid(order.isPaid()).priceAmount(order.getPriceAmount()).userId(order.getUserId()).build();
        if (!CollectionUtils.isEmpty(order.getOrderGoods())) {
            orderDTO.setOrderGoodsDTOList(order.getOrderGoods().stream().map(orderGoods ->
                    OrderGoodsDTO.builder().goodsId(orderGoods.getGoodsId()).orderId(orderGoods.getOrderId()).id(orderGoods.getId()).build()).collect(Collectors.toList()));
        }
        return orderDTO;
    }
}
