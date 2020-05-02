package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
public class ProductService implements RepositoryItemService<Product> {

    private final CRUD mainRepository;

    @Autowired
    public ProductService(CRUD mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public void insert(Product product) {
        mainRepository.insertInRepository(product);
    }

    @Override
    public Product getByID(Product product) {
        return mainRepository.getByID(product);
    }

    @Override
    public void delete(Product product) {
        //todo
    }

    public Long getLastAddedItemID() {
        return mainRepository.getProductIdSequence();
    }

    public void addProduct(Product product, ShoppingCart cart) {
        //todo
    }

    @Override
    public List<Product> getShoppingCartProductList(ShoppingCart cart) {
        return null;
    }

    @Override
    public BigDecimal getTotalValue(ShoppingCart cart) {
        return null;
    }


}
