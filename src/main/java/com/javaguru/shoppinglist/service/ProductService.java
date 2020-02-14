package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CRUD;
import com.javaguru.shoppinglist.repository.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;


public class ProductService implements RepositoryItemService<Product> {

    private CRUD mainRepository;

    public ProductService(CRUD mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public void insertItem(Product product) {
        mainRepository.insertProduct(product);
    }

    @Override
    public Product getItemByID(Product product) {
        return mainRepository.getProductByID(product);
    }

    @Override
    public void deleteItem(Product product) {
        //todo
    }

    public Long getLastAddedItemID() {
        return mainRepository.getProductIdSequence();
    }

    public void addProductInCart(Product product, ShoppingCart cart) {
        //todo
    }

    @Override
    public Map getShoppingCartProductList(ShoppingCart cart) {
        return null;
    }

    @Override
    public BigDecimal getShoppingCartTotalValue(ShoppingCart cart) {
        return null;
    }


}
