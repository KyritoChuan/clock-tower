package com.sotnalucard.products_service.repositories;

import com.sotnalucard.products_service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
