package com.sotnalucard.orders_service.dao;

import com.sotnalucard.orders_service.models.Orders;
import com.sotnalucard.orders_service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void createOrder(Orders order) {
        this.orderRepository.save(order);
    }

    @Override
    public List<Orders> findAllOrders() {
        return this.orderRepository.findAll();
    }
}
