package com.example.product.inentory.productInventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int prodId;

   private String prodName;

   private double price;

   private String description;

   private String category;

   private String unit;


   public Product() {
   }

   public Product(int prodId, String prodName, double price, String description, String category, String unit) {
      this.prodId = prodId;
      this.prodName = prodName;
      this.price = price;
      this.description = description;
      this.category = category;
      this.unit = unit;
   }

   public int getProdId() {
      return prodId;
   }

   public void setProdId(int prodId) {
      this.prodId = prodId;
   }

   public String getProdName() {
      return prodName;
   }

   public void setProdName(String prodName) {
      this.prodName = prodName;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }
}
