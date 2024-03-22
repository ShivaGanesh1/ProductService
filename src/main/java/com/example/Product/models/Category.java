package com.example.Product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @OneToMany(mappedBy = "category")
    // category is the column on the other side
    private List<Product> products;
    private String name;

}
