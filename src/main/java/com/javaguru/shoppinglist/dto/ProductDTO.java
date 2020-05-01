package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDTO {


    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productDiscount;
    private String productDescription;
    private Long productCategory;

    public ProductDTO(Long productId, String productName, BigDecimal productPrice,
                      BigDecimal productDiscount, String productDescription,
                      Long productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDiscount = product.getProductDiscount();
        this.productDescription = product.getProductDescription();
        this.productCategory = product.getProductCategory();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Long productCategory) {
        this.productCategory = productCategory;
    }
}
