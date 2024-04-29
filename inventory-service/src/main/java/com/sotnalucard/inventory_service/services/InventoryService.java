package com.sotnalucard.inventory_service.services;


import com.sotnalucard.inventory_service.dto.ProductRequest;

import java.util.ArrayList;
import java.util.List;

public interface InventoryService {
    boolean isInStock(String sku);
    ArrayList<String> areInStock(List<ProductRequest> products);
}
