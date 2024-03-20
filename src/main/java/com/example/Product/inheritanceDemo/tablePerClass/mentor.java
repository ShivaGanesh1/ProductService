package com.example.Product.inheritanceDemo.tablePerClass;

import com.example.Product.inheritanceDemo.mappedSuperClass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "table_mentor")
public class mentor extends User {
    private String company;
    private Float avgRating;
}
