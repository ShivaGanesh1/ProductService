package com.example.Product.services;

import com.example.Product.dtos.ProductRequestDto;
import com.example.Product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, ProductRequestDto productRequestDto);
}
