package com.javaguru.shoppinglist.service;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public interface RepositoryItemService<T> {

    void insertItem(T object);

    T getItemByID(T object);

    void deleteItem(T object);

    Long getLastAddedItemID();

    void addProduct(Product product, ShoppingCart cart);

    List<Product> getShoppingCartProductList(ShoppingCart cart);

    BigDecimal getShoppingCartTotalValue(ShoppingCart cart);

}
