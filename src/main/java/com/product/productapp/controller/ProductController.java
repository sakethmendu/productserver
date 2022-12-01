package com.product.productapp.controller;

import com.product.productapp.entity.Product;
import com.product.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product-app")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getAllProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/product")
    public void setProduct(@RequestBody @Valid Product product) {
        service.setProduct(product);
    }

    @PatchMapping("/product/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        service.updateProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductbyId(@PathVariable int id) {
        service.deleteProductById(id);
    }

    @PostMapping("/rejected/product")
    public void setRejectedProduct(@RequestBody @Valid Product product) {
        service.setRejectedProduct(product);
    }


}
