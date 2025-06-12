package com.example.product.inentory.productInventory.service.impl;

import com.example.product.inentory.productInventory.dto.InventoryDto;
import com.example.product.inentory.productInventory.entity.Inventory;
import com.example.product.inentory.productInventory.repo.InventoryRepo;
import com.example.product.inentory.productInventory.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {

        Inventory inventory= modelMapper.map(inventoryDto,Inventory.class);

            Inventory saveInventory=inventoryRepo.s;
        return null;
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto, Integer prodId) {
        return null;
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        return List.of();
    }
}
