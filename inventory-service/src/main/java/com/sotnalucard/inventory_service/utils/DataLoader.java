package com.sotnalucard.inventory_service.utils;

import com.sotnalucard.inventory_service.models.Inventory;
import com.sotnalucard.inventory_service.repositories.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class DataLoader implements CommandLineRunner {
    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");

        if(inventoryRepository.findAll().isEmpty()) {
            inventoryRepository.saveAll(
                    List.of(
                            Inventory.builder().sku("000001").quantity(10L).build(),
                            Inventory.builder().sku("000002").quantity(20L).build(),
                            Inventory.builder().sku("000003").quantity(30L).build(),
                            Inventory.builder().sku("000004").quantity(0L).build()
                    )
            );
        }
    }
}

