package com.sotnalucard.inventory_service.dao;

import com.sotnalucard.inventory_service.models.Inventory;
import com.sotnalucard.inventory_service.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDaoImpl implements InventoryDao {
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public boolean hasStockInInventory(String sku) {
        var inventory = this.inventoryRepository.findBySku(sku);

        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    @Override
    public List<Inventory> findBySkuInInventory(List<String> skus) {
        return this.inventoryRepository.findBySkuIn(skus);
    }
}
