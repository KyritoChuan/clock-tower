package com.sotnalucard.inventory_service.dao;

import com.sotnalucard.inventory_service.models.Inventory;

import java.util.List;

public interface InventoryDao {
    boolean hasStockInInventory(String sku);
    List<Inventory> findBySkuInInventory(List<String> skus);
}
