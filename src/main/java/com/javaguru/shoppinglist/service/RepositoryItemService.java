package com.javaguru.shoppinglist.service;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public interface RepositoryItemService<T> {

    void insert(T object);

    T getByID(T object);

    void delete(T object);

    Long getLastAddedItemID();

    void addProduct(Product product, ShoppingCart cart);

    List<Product> getShoppingCartProductList(ShoppingCart cart);

    BigDecimal getTotalValue(ShoppingCart cart);

}
