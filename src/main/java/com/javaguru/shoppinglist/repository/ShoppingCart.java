package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Objects;

//@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements CRUD {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    private HashMap<Long, Product> productList = new HashMap<>();

    @Override
    public void insertProduct(Product product) {
        productList.put(product.getProductId(), product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Long, Product> getProductList() {
        return productList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productList);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }

    @Override
    public Product getProductByID(Product object) {
        return null;
    }

    @Override
    public boolean ifProductExistsByName(Product product) {
        return false;
    }

    @Override
    public void deleteProductByID(Product object) {
    }

    @Override
    public void insertShoppingCart(ShoppingCart cart) {
    }

    @Override
    public ShoppingCart getShoppingCartByID(ShoppingCart cart) {
        return null;
    }

    @Override
    public void deleteShoppingCartByID(ShoppingCart cart) {
    }

    @Override
    public Long getProductIdSequence() {
        return null;
    }

    @Override
    public Long getCartIdSequence() {
        return null;
    }

    @Override
    public HashMap getProductRepository() {
        return null;
    }
}
