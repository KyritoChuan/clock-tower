package com.sotnalucard.products_service.dao;

import com.sotnalucard.products_service.models.Product;
import com.sotnalucard.products_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
}
