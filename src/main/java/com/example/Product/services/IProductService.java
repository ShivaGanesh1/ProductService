package com.example.Product.services;

import com.example.Product.dtos.ProductRequestDto;
import com.example.Product.exceptions.InvalidProductIdException;
import com.example.Product.exceptions.ProductDoesNotFoundException;
import com.example.Product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();
    Product addProduct(Product product);

    Product updateProduct(Long id, Product product)throws ProductDoesNotFoundException;
}
