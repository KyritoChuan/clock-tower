package com.sotnalucard.orders_service.repositories;

import com.sotnalucard.orders_service.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
