package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

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

    //    @Override
//    public void addProductInCart(Product product, ShoppingCart cart) {    //вариант для работы с инмемори
//        mainRepository.getShoppingCartByID(cart).insertProduct(product);
//    }
    @Override
    public void addProduct(Product product, ShoppingCart cart) {  //вариант для работы с внешней базой
        mainRepository.addProductToCart(product, cart);
    }

    @Override
    public Long getLastAddedItemID() {
        return mainRepository.getCartIdSequence();
    }

    //    @Override
//    public Map getShoppingCartProductList(ShoppingCart cart) {   //вариант для работы с инмемори
//        return mainRepository.getShoppingCartByID(cart).getProductList();
//    }
    @Override
    public List<Product> getShoppingCartProductList(ShoppingCart cart) {  //вариант для работы с внешней базой
        return mainRepository.getShoppingCartProductList(cart);
    }

//    @Override
//    public BigDecimal getShoppingCartTotalValue(ShoppingCart cart) {  // вариант для работы с инмемори
//        BigDecimal price = new BigDecimal("0");
//        for (Map.Entry<Long, Product> entry : cart.getProductList().entrySet()) {
//            price = price.add(entry.getValue().getProductPrice());
//        }
//        return price;
//    }

    @Override
    public BigDecimal getShoppingCartTotalValue(ShoppingCart cart) {  //вариант для работы с внешней базой
        BigDecimal value = new BigDecimal("0");
        List<Product> productList = getShoppingCartProductList(cart);
        if (productList == null) {
            return value;
        }
        int i;
        for (i = 0; i <= (productList.size() - 1); i++) {
            value = value.add(productList.get(i).getProductPrice());
        }
        return value;
    }
}
