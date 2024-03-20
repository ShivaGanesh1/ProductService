package com.example.Product.repositeries;

import com.example.Product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepositories extends JpaRepository<Product,Long> {
    public Product findByName(String name);

    public  Optional<Product> findById(Long id);

    public List<Product> findByNameAndDescriptionAndPriceGreaterThan(String title, String Description, int price);
    Product save(Product product);

}
