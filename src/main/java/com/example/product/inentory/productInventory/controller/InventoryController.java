package com.example.product.inentory.productInventory.controller;

import com.example.product.inentory.productInventory.dto.InventoryDto;
import com.example.product.inentory.productInventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    private InventoryService service;
    @PostMapping("/")
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto)
    {
        InventoryDto inventory=service.createInventory(inventoryDto);
        return new ResponseEntity<>(inventory, HttpStatus.CREATED);

    }
    @PutMapping("/{prodId}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable Integer prodIdd,@RequestBody InventoryDto inventoryDto)
    {
        InventoryDto inventory=service.updateInventory(inventoryDto,prodIdd);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/")
    public ResponseEntity<List<InventoryDto>> getAllInventory()
    {
        List<InventoryDto> inventory=service.getAllInventory();
        return ResponseEntity.ok(inventory);
    }

}
