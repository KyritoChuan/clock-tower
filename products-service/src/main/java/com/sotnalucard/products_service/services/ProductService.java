package com.sotnalucard.products_service.services;

import com.sotnalucard.products_service.dto.ProductRequest;
import com.sotnalucard.products_service.dto.ProductResponse;

import java.util.List;


public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
}
