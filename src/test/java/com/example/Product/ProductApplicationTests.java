package com.example.Product;

import com.example.Product.repositeries.ProductWithIdName;
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
	@Test
	public void getSomeThing()
	{
		ProductWithIdName p = productRepositories.something(1L);
		System.out.println(p.getName() + " " + p.getPrice());

		///System.out.println(p.getName() + " " + p.getDescription());
	}
	@Test
	public void getSomeThingfromMySql()
	{
		Product p = productRepositories.somethingMySqlQuery(1L);
		System.out.println(p.getName() + " " + p.getPrice());

		///System.out.println(p.getName() + " " + p.getDescription());
	}

}
