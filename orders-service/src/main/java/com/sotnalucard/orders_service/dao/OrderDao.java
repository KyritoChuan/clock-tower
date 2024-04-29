package com.sotnalucard.orders_service.dao;

import com.sotnalucard.orders_service.models.Orders;

import java.util.List;

public interface OrderDao {
    void createOrder(Orders order);
    List<Orders> findAllOrders();
}
