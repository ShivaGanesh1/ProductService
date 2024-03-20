package com.example.Product.services;

import com.example.Product.dtos.ProductRequestDto;
import com.example.Product.exceptions.InvalidProductIdException;
import com.example.Product.exceptions.ProductDoesNotFoundException;
import com.example.Product.models.Category;
import com.example.Product.models.Product;
import com.example.Product.repositeries.CategoryRepository;
import com.example.Product.repositeries.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements IProductService{
    private ProductRepositories productRepositories;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(ProductRepositories productRepositories,CategoryRepository categoryRepository)
    {
        this.productRepositories = productRepositories;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public Product getSingleProduct(Long id) throws InvalidProductIdException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional =categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty())
        {
            Category categoryToSave = new Category();
            categoryToSave.setName(product.getCategory().getName());
            Category savedCategory = categoryRepository.save(categoryToSave);
            product.setCategory(savedCategory);
        }
        else
        {
            product.setCategory(categoryOptional.get());
        }
        Product savedProduct = productRepositories.save(product);

        return savedProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductDoesNotFoundException{
        Optional<Product> productOptional = productRepositories.findById(id);
        if(productOptional.isEmpty())
        {
            throw new ProductDoesNotFoundException("product with id" + id + "does not found");
        }
        Product existingProduct = productOptional.get();
        Product updatedProduct = new Product();
        updatedProduct.setName(
                product.getName() != null ?
                        product.getName() : existingProduct.getName()
        );
        updatedProduct.setDescription(
                product.getDescription() != null ?
                        product.getDescription() :existingProduct.getDescription()
        );
        updatedProduct.setPrice(
                product.getPrice() > 0 ?
                        product.getPrice() : existingProduct.getPrice()
        );
        updatedProduct.setImage(
                product.getImage() != null ?
                        product.getImage() : existingProduct.getImage()
        );
        Optional<Category> categoryOptional =categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty())
        {
            Category categoryToSave = new Category();
            categoryToSave.setName(product.getCategory().getName());
            Category savedCategory = categoryRepository.save(categoryToSave);
            updatedProduct.setCategory(savedCategory);
        }
        else
        {
            updatedProduct.setCategory(categoryOptional.get());
        }
        Product savedUpdatedProduct = productRepositories.save(updatedProduct);
        return savedUpdatedProduct;
    }
}
