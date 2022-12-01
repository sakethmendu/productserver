package com.product.productapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int productId;
    @NotNull(message = "Product name Not to be null")
    private String productName;
    @NotNull(message = "Product Description Not to be null")
    private String productDescription;
    @NotNull(message = "Product URL Not to be null")
    private String productUrl;

    public Product() {
    }

    public Product(int productId, String productName, String productDescription, String productUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productUrl = productUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
