package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

public interface CRUD {

    void insertProduct(Product product);

    void insertShoppingCart(ShoppingCart cart);

    Product getProductByID(Product product);

    ShoppingCart getShoppingCartByID(ShoppingCart cart);

    void deleteProductByID(Product product);

    void deleteShoppingCartByID(ShoppingCart cart);

    Long getProductIdSequence();

    Long getCartIdSequence();

}


