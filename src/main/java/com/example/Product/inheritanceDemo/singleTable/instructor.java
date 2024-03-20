package com.example.Product.inheritanceDemo.singleTable;

import com.example.Product.inheritanceDemo.mappedSuperClass.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_instructor")
@DiscriminatorValue("2")

public class instructor extends User {
    private String specialization;
}
