package com.example.Product.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class ProductRequestDto
{
    private String title;
    private String description;
    private int price;
    private String image;
    private String category;

}
