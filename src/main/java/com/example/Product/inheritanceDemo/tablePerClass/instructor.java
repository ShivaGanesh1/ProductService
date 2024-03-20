package com.example.Product.inheritanceDemo.tablePerClass;

import com.example.Product.inheritanceDemo.mappedSuperClass.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "table_instructor")

public class instructor extends User {
    private String specialization;
}
