package com.example.product.inentory.productInventory.service;

import com.example.product.inentory.productInventory.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    InventoryDto createInventory(InventoryDto inventoryDto);
    InventoryDto updateInventory(InventoryDto inventoryDto,Integer prodId);
    List<InventoryDto>getAllInventory();
}
