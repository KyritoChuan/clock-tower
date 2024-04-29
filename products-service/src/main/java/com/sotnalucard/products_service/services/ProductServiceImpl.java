package com.sotnalucard.products_service.services;

import com.sotnalucard.products_service.dao.ProductDao;
import com.sotnalucard.products_service.dto.ProductRequest;
import com.sotnalucard.products_service.dto.ProductResponse;
import com.sotnalucard.products_service.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public void createProduct(ProductRequest productRequest) {
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                .build();

        productDao.createProduct(product);

        log.info("Product added: {}", product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        var products = this.productDao.findAllProducts();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }

}
