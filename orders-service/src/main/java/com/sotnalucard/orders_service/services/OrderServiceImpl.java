package com.sotnalucard.orders_service.services;

import com.sotnalucard.orders_service.dao.OrderDao;
import com.sotnalucard.orders_service.dto.*;
import com.sotnalucard.orders_service.models.Orders;
import com.sotnalucard.orders_service.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    WebClient webClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        ResponseEntity<ArrayList> inventoryClient = this.webClient.post()
                .uri("http://localhost:8083/api/inventory/in-stock")
                .bodyValue(orderRequest.getProducts())
                .retrieve()
                .toEntity(ArrayList.class)
                .block();

        if(inventoryClient.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("Error in connection with Inventory Service, try later");
        }

        if(inventoryClient.getStatusCode() == HttpStatus.OK && inventoryClient.getBody().size() > 0) {
            throw new IllegalArgumentException("Some of the products are not in stock");
        }

        Orders order = new Orders();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setProducts(
                orderRequest.getProducts().stream().map(productRequest ->
                        mapProductRequestToProductEntity(productRequest, order))
                        .collect(Collectors.toList())
        );
        this.orderDao.createOrder(order);
    }

    private Product mapProductRequestToProductEntity(ProductRequest productRequest, Orders order) {
        return Product.builder()
                .id(productRequest.getId())
                .sku(productRequest.getSku())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .orders(order).build();
    }

    public List<OrderResponse> getAllOrders() {
        List<Orders> orders = this.orderDao.findAllOrders();

        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());
    }

    private OrderResponse mapToOrderResponse(Orders order) {
        return new OrderResponse(order.getId(), order.getOrderNumber(),
                order.getProducts().stream().map(this::mapToProductRequest).collect(Collectors.toList()));
    }

    private ProductResponse mapToProductRequest(Product product) {
        return new ProductResponse(product.getId(),product.getSku(), product.getPrice(), product.getQuantity());
    }
}
