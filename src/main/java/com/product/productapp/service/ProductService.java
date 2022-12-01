package com.product.productapp.service;

import com.product.productapp.entity.Product;
import com.product.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findByProductId(id);
    }

    public void setProduct(Product product) {
        repository.save(product);
    }


    public void updateProduct(Product product, int id) {
        repository.updateProduct(product.getProductDescription(), product.getProductName(), product.getProductUrl(), id);
    }

    public void deleteProductById(int id) {
        repository.deleteById(id);
    }

    public void setRejectedProduct(Product product) {
        repository.updateRejectedProduct(product.getProductDescription(), product.getProductName(), product.getProductUrl());
    }
}
