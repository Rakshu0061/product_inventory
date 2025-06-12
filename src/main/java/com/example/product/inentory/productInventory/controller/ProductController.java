package com.example.product.inentory.productInventory.controller;

import com.example.product.inentory.productInventory.dto.ProductDto;
import com.example.product.inentory.productInventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductDto>createProduct(@Valid @RequestBody ProductDto productDto)
    {
        ProductDto created=productService.createProduct(productDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>>getAllProduct()
    {
        List<ProductDto> allproducts= productService.getAllProducts();
        return  ResponseEntity.ok(allproducts);
    }

    @GetMapping("/{prodId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int prodId)
    {
        ProductDto product=productService.getProductById(prodId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @PathVariable int prodId, @RequestBody ProductDto productDto)
    {
        ProductDto updateProduct=productService.updateProduct(productDto,prodId);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{prodId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int prodId)
    {
        productService.deleteProduct(prodId);
         return ResponseEntity.noContent().build();
    }
}

