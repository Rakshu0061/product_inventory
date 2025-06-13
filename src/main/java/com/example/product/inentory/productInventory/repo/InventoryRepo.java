package com.example.product.inentory.productInventory.repo;

import com.example.product.inentory.productInventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
}
