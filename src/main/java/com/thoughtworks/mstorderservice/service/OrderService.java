package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.dto.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO payOrder(int orderId);

}
