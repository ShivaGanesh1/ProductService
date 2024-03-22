package com.example.Product.repositeries;

import com.example.Product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepositories extends JpaRepository<Product,Long> {
    public Product findByName(String name);

    public  Optional<Product> findById(Long id);

    public List<Product> findByNameAndDescriptionAndPriceGreaterThan(String title, String Description, int price);
    Product save(Product product);

    // Hql query : give the query in terms of models

    @Query(value = "select p.id as id,p.name as name,p.price as price from Product p where p.id = :ganesh")
    ProductWithIdName something(@Param("ganesh") Long id);
    @Query(value = "Select * from Product where id = :sugan",nativeQuery = true)
    Product somethingMySqlQuery(@Param("sugan")Long id);

}
