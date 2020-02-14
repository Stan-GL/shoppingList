package com.javaguru.shoppinglist.service;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

public interface RepositoryItemService<T> {

    void insertItem(T object);

    T getItemByID(T object);

    void deleteItem(T object);

    Long getLastAddedItemID();

    void addProductInCart(Product product, ShoppingCart cart);

    Map getShoppingCartProductList(ShoppingCart cart);

    BigDecimal getShoppingCartTotalValue(ShoppingCart cart);

}
