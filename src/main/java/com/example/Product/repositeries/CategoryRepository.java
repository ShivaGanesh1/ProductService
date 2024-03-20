package com.example.Product.repositeries;

import com.example.Product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);
    Optional<Category> findByName(String name);
}
