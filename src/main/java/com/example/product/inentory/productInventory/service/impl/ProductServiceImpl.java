package com.example.product.inentory.productInventory.service.impl;

import com.example.product.inentory.productInventory.dto.ProductDto;
import com.example.product.inentory.productInventory.entity.Product;
import com.example.product.inentory.productInventory.exception.ProductNotFoundException;
import com.example.product.inentory.productInventory.repo.ProductRepo;
import com.example.product.inentory.productInventory.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product=modelMapper.map(productDto,Product.class);
        Product saveProduct=productRepo.save(product);
        return modelMapper.map(saveProduct,ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer prodId) {
        Product product=productRepo.findById(prodId).orElseThrow(()-> new ProductNotFoundException("product not found"));
        product.setCategory(productDto.getCategory());
        product.setProdName(product.getProdName());
        product.setPrice(productDto.getPrice());
        product.setUnit(productDto.getUnit());
        product.setDescription(productDto.getDescription());
        Product updateProduct= productRepo.save(product);

        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
       List<Product> product=productRepo.findAll();
       List<ProductDto> productList=product.stream().map((products)->modelMapper.map(products,ProductDto.class)).collect(Collectors.toList());
        return productList;
    }

    @Override
    public ProductDto getProductById(Integer prodId) {
        Product product=productRepo.findById(prodId).orElseThrow(()->new ProductNotFoundException("product with" +prodId+" not found"));
        return modelMapper.map(product,ProductDto.class);
    }



    @Override
    public void deleteProduct(Integer prodId) {
        productRepo.findById(prodId).orElseThrow(()->new ProductNotFoundException("product"+prodId+" not found"));
        productRepo.deleteById(prodId);
    }


}
