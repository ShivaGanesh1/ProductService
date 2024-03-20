package com.example.Product;

import com.example.Product.models.Product;
import com.example.Product.repositeries.ProductRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {
	@Autowired

	ProductRepositories productRepositories;

	@Test
	void contextLoads() {
	}
	@Test
	public void getSomeData()
	{
		Product product = productRepositories.findByName("MacBook");
		System.out.println(product.getId() + " "+ product.getPrice());
	}

}
