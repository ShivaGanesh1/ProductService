package com.example.Product.services;

import com.example.Product.dtos.ProductRequestDto;
import com.example.Product.dtos.ProductResponseDto;
import com.example.Product.models.Category;
import com.example.Product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    @Autowired
    RestTemplate restTemplate;
    public Product getProductFromResponseDto(ProductResponseDto responseDto)
    {
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setName(responseDto.getTitle());
        product.setPrice(responseDto.getPrice());
        product.setImage(responseDto.getImage());
        product.setDescription(responseDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(responseDto.getCategory());
        return product;
    }
    @Override

    public Product getSingleProduct(Long id) throws InvalidProductIdException
    {
        if(id > 20)
        {
            throw new InvalidProductIdException();
        }
        // i should pass this id to fakestore to get the details of this product.
        // 'https://fakestoreapi.com/products/1'
        ProductResponseDto response =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                ProductResponseDto.class);
        return getProductFromResponseDto(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] responseDtoList =
        restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);
        List<Product> Output = new ArrayList<>();
        for(ProductResponseDto productResponseDto: responseDtoList)
        {
            Output.add(getProductFromResponseDto(productResponseDto));
        }
        return Output;
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productRequestDto,ProductResponseDto.class);
        HttpMessageConverterExtractor<ProductResponseDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductResponseDto.class, restTemplate.getMessageConverters());
        ProductResponseDto productResponseDto =
                restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return getProductFromResponseDto(productResponseDto);
    }
}
