package com.example.product.inentory.productInventory.service.impl;

import com.example.product.inentory.productInventory.dto.InventoryDto;
import com.example.product.inentory.productInventory.entity.Inventory;
import com.example.product.inentory.productInventory.entity.Product;
import com.example.product.inentory.productInventory.exception.InventoryNotFoundException;
import com.example.product.inentory.productInventory.repo.InventoryRepo;
import com.example.product.inentory.productInventory.repo.ProductRepo;
import com.example.product.inentory.productInventory.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;
   @Autowired
    private ProductRepo productRepo;

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {

        Product product= productRepo.findById(inventoryDto.getProdId()).orElseThrow(()->new InventoryNotFoundException("product not found"));

        Inventory inventory= modelMapper.map(inventoryDto,Inventory.class);
            inventory.setProduct(product);
            Inventory saveInventory=inventoryRepo.save(inventory);
        InventoryDto savedResponse= modelMapper.map(saveInventory,InventoryDto.class);
        savedResponse.setProdId(product.getProdId());
        return savedResponse;
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto, Integer prodId) {
         Inventory update= inventoryRepo.findById(prodId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found."));
        update.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        update.setLastUpdated(LocalDateTime.now());
         Inventory updated=inventoryRepo.save(update);

        return modelMapper.map(updated,InventoryDto.class);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
       List<Inventory> inventories=inventoryRepo.findAll();
       List<InventoryDto> inventoryList=inventories.stream().map((inventory -> modelMapper.map(inventory,InventoryDto.class))).toList();
        return inventoryList;
    }
}
