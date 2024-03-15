package com.example.Product.controllers;

import com.example.Product.dtos.ProductRequestDto;
import com.example.Product.dtos.ProductWrapper;
import com.example.Product.models.Product;
import com.example.Product.services.IProductService;
import com.example.Product.services.InvalidProductIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private IProductService productService;
    // get all the products
    @GetMapping("/products")

    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> getSingleProduct(@PathVariable("id") Long id)
    {
        ResponseEntity<ProductWrapper> response;
        try {
            Product singleProduct = productService.getSingleProduct(id);
            ProductWrapper productWrapper = new ProductWrapper(singleProduct,"Successfully retrived the dat");
            response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        } catch (InvalidProductIdException e) {
            ProductWrapper productWrapper = new ProductWrapper(null,"Product is not present");
            response = new ResponseEntity<>(productWrapper,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        return new Product();
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                 @RequestBody ProductRequestDto productRequestDto)
    {
        return productService.updateProduct(id,productRequestDto);
    }
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id)
    {
        return true;
    }
}
