package com.example.Product.inheritanceDemo.joinedTable;

import com.example.Product.inheritanceDemo.mappedSuperClass.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jd_instructor")
@PrimaryKeyJoinColumn(name = "User_id")

public class instructor extends User {
    private String specialization;
}
