package com.sotnalucard.products_service.controllers;


import com.sotnalucard.products_service.dto.ProductRequest;
import com.sotnalucard.products_service.dto.ProductRequest;
import com.sotnalucard.products_service.dto.ProductResponse;
import com.sotnalucard.products_service.models.Product;
import com.sotnalucard.products_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest) {
        this.productService.createProduct(productRequest);
    }
}
