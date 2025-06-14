package com.example.product.inentory.productInventory.service.impl;

import com.example.product.inentory.productInventory.dto.InventoryDto;
import com.example.product.inentory.productInventory.entity.Inventory;
import com.example.product.inentory.productInventory.entity.Product;
import com.example.product.inentory.productInventory.exception.InventoryNotFoundException;
import com.example.product.inentory.productInventory.exception.ProductNotFoundException;
import com.example.product.inentory.productInventory.mapperHelper.InventoryMapper;
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

        Product product = productRepo.findById(inventoryDto.getProdId())
            .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + inventoryDto.getProdId()));

        Inventory inventory = InventoryMapper.toEntity(inventoryDto,product);
       // inventory.setProduct(product);

        Inventory savedInventory = inventoryRepo.save(inventory);

//        InventoryDto savedResponse = modelMapper.map(savedInventory, InventoryDto.class);
//
//        // ✅ Fix: manually set prodId
//        savedResponse.setProdId(savedInventory.getProduct().getProdId());

        return InventoryMapper.toDto(savedInventory);
    }


    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto, Integer prodId) {
         Inventory update= inventoryRepo.findById(prodId).orElseThrow(()->new InventoryNotFoundException("Inventory Not Found."));
        update.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        update.setLastUpdated(LocalDateTime.now());
         Inventory updated=inventoryRepo.save(update);
//        InventoryDto responseDto = modelMapper.map(updated, InventoryDto.class);
//
//        // ✅ Set prodId manually
//        responseDto.setProdId(updated.getProduct().getProdId());

        return InventoryMapper.toDto(updated);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
       List<Inventory> inventories=inventoryRepo.findAll();
       List<InventoryDto> inventoryList=inventories.stream().map((inventory -> modelMapper.map(inventory,InventoryDto.class))).toList();
        return inventoryList;
    }
}
