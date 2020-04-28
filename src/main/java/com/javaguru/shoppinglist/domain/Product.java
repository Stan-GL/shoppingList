package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")

public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_discount")
    private BigDecimal productDiscount;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_category")
    private int productCategory;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Set<ShoppingCartProductList> productLists;

    public Set<ShoppingCartProductList> getProductLists() {
        return productLists;
    }

    public void setProductDiscount(BigDecimal discount) {
        this.productDiscount = discount;
    }

    @Override
    public String toString() {
        return "Product{ " +
                "id=" + productId +
                ", name='" + productName + '\'' +
                ", price=" + productPrice +
                ", discount=" + productDiscount +
                ", description='" + productDescription + '\'' +
                ", category=" + productCategory +
                '}';
    }

    public void setProductDescription(String description) {
        this.productDescription = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice) &&
                Objects.equals(productDiscount, product.productDiscount) &&
                Objects.equals(productDescription, product.productDescription) &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productDiscount, productDescription, productCategory);
    }

//    public void setProductCategory(Category category) {
//        this.productCategory = category;
//    }

    public BigDecimal getProductDiscount() {
        return productDiscount;
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

    public void setProductPrice(BigDecimal price) {
        this.productPrice = price;
    }

}