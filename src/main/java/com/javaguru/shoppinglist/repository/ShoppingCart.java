package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart implements CRUD {

    private Long id;
    private String name;
    private Map<Long, Product> productList = new HashMap<>();

    @Override
    public void insertProduct(Product product) {
        productList.put(product.getId(), product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Product> getProductList() {
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
}
