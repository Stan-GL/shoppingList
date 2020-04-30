package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    private Long productCategory;

    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "shopping_cart_product_list",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "shopping_cart_id")})
    private List<ShoppingCart> cartList;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private Set<ShoppingCartProductList> productLists;

//    public Set<ShoppingCartProductList> getProductLists() {
//        return productLists;
//    }

    public void setProductDiscount(BigDecimal discount) {
        this.productDiscount = discount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Long getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Long productCategory) {
        this.productCategory = productCategory;
    }

    public List<ShoppingCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShoppingCart> cartList) {
        this.cartList = cartList;
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