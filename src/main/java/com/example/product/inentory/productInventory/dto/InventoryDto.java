package com.example.product.inentory.productInventory.dto;

import com.example.product.inentory.productInventory.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class InventoryDto {

    private int inventoryId;
    private int prodId;
    @NotNull
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer availableQuantity;

    @NotNull
    private LocalDateTime lastUpdated;


    public InventoryDto(int inventoryId, Integer availableQuantity, LocalDateTime lastUpdated) {
        this.inventoryId = inventoryId;
        this.availableQuantity = availableQuantity;
        this.lastUpdated = lastUpdated;
    }

    public InventoryDto() {
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


}
