package com.sotnalucard.products_service.dao;

import com.sotnalucard.products_service.models.Product;

import java.util.List;

public interface ProductDao {
    void createProduct(Product product);
    List<Product> findAllProducts();
}
