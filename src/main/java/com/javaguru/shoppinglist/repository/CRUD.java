package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.HashMap;
import java.util.List;

public interface CRUD {

    void insertInRepository(Product product);

    void addProductToCart(Product product, ShoppingCart cart);

    void insert(ShoppingCart cart);

    Product getByID(Product product);

    boolean ifProductExistsByName(Product product);

    ShoppingCart getByID(ShoppingCart cart);

    void deleteProductByID(Product product);

    void deleteByID(ShoppingCart cart);

    Long getProductIdSequence();

    Long getCartIdSequence();

    List<Product> getShoppingCartProductList(ShoppingCart cart);

    HashMap<Long, Product> getProductRepository();

}


