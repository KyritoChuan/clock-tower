package com.sotnalucard.orders_service.services;

import com.sotnalucard.orders_service.dto.OrderRequest;
import com.sotnalucard.orders_service.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
    List<OrderResponse> getAllOrders();
}
