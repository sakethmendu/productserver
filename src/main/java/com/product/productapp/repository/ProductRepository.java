package com.product.productapp.repository;

import com.product.productapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductId(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Product SET product_description = :ProductDescription, product_name = :ProductName, product_url = :URL WHERE product_id= :product_ID", nativeQuery = true)
    public void updateProduct(@Param("ProductDescription") String ProductDescription, @Param("ProductName") String ProductName,
                              @Param("URL") String URL, @Param("product_ID") int product_ID);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rejected_products (`product_description`, `product_name`, `product_url`) VALUES (:ProductDescription,:ProductName,:URL);", nativeQuery = true)
    public void updateRejectedProduct(@Param("ProductDescription") String ProductDescription, @Param("ProductName") String ProductName,
                              @Param("URL") String URL);


}
