package com.sotnalucard.inventory_service.controllers;


import com.sotnalucard.inventory_service.dto.ProductRequest;
import com.sotnalucard.inventory_service.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku) {
        return this.inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArrayList<String>> areInStock(@RequestBody List<ProductRequest> product) {
        var errorList = this.inventoryService.areInStock(product);
        return new ResponseEntity<ArrayList<String>>(errorList, HttpStatus.OK);
    }
}
