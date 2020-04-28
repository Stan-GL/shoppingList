package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.HashMap;
import java.util.List;

public interface CRUD {

    void insertProductInRepository(Product product);

    void addProductToCart(Product product, ShoppingCart cart);

    void insertShoppingCart(ShoppingCart cart);

    Product getProductByID(Product product);

    boolean ifProductExistsByName(Product product);

    ShoppingCart getShoppingCartByID(ShoppingCart cart);

    void deleteProductByID(Product product);

    void deleteShoppingCartByID(ShoppingCart cart);

    Long getProductIdSequence();

    Long getCartIdSequence();

    List<Product> getShoppingCartProductList(ShoppingCart cart);

    HashMap<Long, Product> getProductRepository();

}


