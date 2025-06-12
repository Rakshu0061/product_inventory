package com.example.product.inentory.productInventory.repo;

import com.example.product.inentory.productInventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
