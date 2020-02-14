package com.javaguru.shoppinglist.console.service;

import com.javaguru.shoppinglist.console.input.ExitException;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

public interface UIService<T> {

    void insert() throws ExitException;

    T create() throws ExitException;

    void deleteByID(T object) throws ExitException;

    T getByID() throws ExitException;

    void addProductToCart(Product product, ShoppingCart cart) throws ExitException;

    Map getProductList(ShoppingCart cart) throws ExitException;

    BigDecimal getCartValue(ShoppingCart cart) throws ExitException;

}
