package com.example.Product.exceptions;

import jakarta.persistence.criteria.CriteriaBuilder;

public class InvalidProductIdException extends Exception {
    public InvalidProductIdException(String s) {
        super(s);
    }
    public InvalidProductIdException()
    {
        System.out.println("product not fund");
    }

}
