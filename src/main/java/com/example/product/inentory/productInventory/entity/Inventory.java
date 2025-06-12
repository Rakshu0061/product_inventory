package com.example.product.inentory.productInventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;
    private Integer availableQuantity;
    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "prod_id",nullable = false,unique = true)
    private Product product;


    public Inventory(int inventoryId, Integer availableQuantity, LocalDateTime lastUpdated, Product product) {
        this.inventoryId = inventoryId;
        this.availableQuantity = availableQuantity;
        this.lastUpdated = lastUpdated;
        this.product = product;
    }

    public Inventory() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
