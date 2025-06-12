package com.example.product.inentory.productInventory.service;

import com.example.product.inentory.productInventory.dto.ProductDto;
import com.example.product.inentory.productInventory.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto,Integer prodId);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Integer prodId);
    void deleteProduct(Integer prodId);


}
