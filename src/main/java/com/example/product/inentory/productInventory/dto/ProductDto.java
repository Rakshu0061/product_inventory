package com.example.product.inentory.productInventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

    private int prodId;

    @NotBlank(message = "product name is required")
    @Size(min = 2, max = 50)
    private String prodName;
    @Positive(message = "product price must be positive")
    private double price;
    @Size(max=200,message = "description cannot be longer than 200 characters ")
    private String description;
    @NotBlank(message = "category is required")
    private String category;
    @NotBlank(message = "unit is required")
    private String unit;




    public ProductDto( String prodName, double price, String description, String category, String unit) {

        this.prodName = prodName;
        this.price = price;
        this.description = description;
        this.category = category;
        this.unit = unit;
    }

    public ProductDto() {
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
