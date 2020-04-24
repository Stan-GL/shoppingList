package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CRUD;
import com.javaguru.shoppinglist.repository.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class ShoppingCartService implements RepositoryItemService<ShoppingCart> {

    private final CRUD mainRepository;

    @Autowired
    public ShoppingCartService(CRUD repository) {
        this.mainRepository = repository;
    }

    @Override
    public void insertItem(ShoppingCart cart) {
        mainRepository.insertShoppingCart(cart);
    }

    @Override
    public ShoppingCart getItemByID(ShoppingCart cart) {
        return mainRepository.getShoppingCartByID(cart);
    }

    @Override
    public void deleteItem(ShoppingCart cart) {
        mainRepository.deleteShoppingCartByID(cart);
    }

    @Override
    public void addProductInCart(Product product, ShoppingCart cart) {
        mainRepository.getShoppingCartByID(cart).insertProduct(product);
    }

    @Override
    public Long getLastAddedItemID() {
        return mainRepository.getCartIdSequence();
    }

    @Override
    public Map getShoppingCartProductList(ShoppingCart cart) {
        return mainRepository.getShoppingCartByID(cart).getProductList();
    }

    @Override
    public BigDecimal getShoppingCartTotalValue(ShoppingCart cart) {
        BigDecimal price = new BigDecimal("0");
        for (Map.Entry<Long, Product> entry : cart.getProductList().entrySet()) {
            price = price.add(entry.getValue().getProductPrice());
        }
        return price;
    }
}
