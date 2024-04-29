package com.sotnalucard.inventory_service.services;

import com.sotnalucard.inventory_service.dao.InventoryDao;
import com.sotnalucard.inventory_service.dto.ProductRequest;
import com.sotnalucard.inventory_service.models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryDao inventoryDao;

    @Override
    public boolean isInStock(String sku) {
        var isStock = this.inventoryDao.hasStockInInventory(sku);
        return isStock;
    }

    public ArrayList<String> areInStock(List<ProductRequest> products) {
        var errorList = new ArrayList<String>();
        List<String> skus = products.stream().map(ProductRequest::getSku).collect(Collectors.toList());
        List<Inventory> inventoryList = this.inventoryDao.findBySkuInInventory(skus);

        products.forEach(product -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(product.getSku())).findFirst();
            if(inventory.isEmpty()) {
                errorList.add("Product with sku " + product.getSku() + "does not exist");
            } else if (inventory.get().getQuantity() < product.getQuantity()) {
                errorList.add("Product with sku " + product.getSku() + "has insufficient quantity");
            }
        });
        return errorList;
    }
}

