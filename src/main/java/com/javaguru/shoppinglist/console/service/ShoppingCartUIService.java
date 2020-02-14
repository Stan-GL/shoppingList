package com.javaguru.shoppinglist.console.service;

import com.javaguru.shoppinglist.console.input.ExitException;
import com.javaguru.shoppinglist.console.input.SetShoppingCartID;
import com.javaguru.shoppinglist.console.input.SetShoppingCartName;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ShoppingCart;
import com.javaguru.shoppinglist.service.RepositoryItemService;
import com.javaguru.shoppinglist.service.validation.ValidationService;

import java.math.BigDecimal;
import java.util.Map;

public class ShoppingCartUIService implements UIService<ShoppingCart> {


    private RepositoryItemService<ShoppingCart> shoppingCartService;
    private ValidationService<ShoppingCart> shoppingCartValidationRules;

    public ShoppingCartUIService(RepositoryItemService<ShoppingCart> shoppingCartService,
                                 ValidationService<ShoppingCart> shoppingCartValidationRules) {

        this.shoppingCartService = shoppingCartService;
        this.shoppingCartValidationRules = shoppingCartValidationRules;
    }

    @Override
    public void insert() throws ExitException {
        shoppingCartService.insertItem(create());
    }

    @Override
    public ShoppingCart create() throws ExitException {
        ShoppingCart cart = new ShoppingCart();
        validateAndSetName(cart);
        return cart;
    }

    private void validateAndSetName(ShoppingCart cart) throws ExitException {
        SetShoppingCartName name = new SetShoppingCartName();
        boolean isOK = false;
        while (!isOK) {
            name.setShoppingCartName(cart);
            isOK = shoppingCartValidationRules.validateItemName(cart);
        }
    }

    @Override
    public ShoppingCart getByID() throws ExitException {
        ShoppingCart cart = new ShoppingCart();
        SetShoppingCartID id = new SetShoppingCartID();
        boolean isOK = false;
        while (!isOK) {
            if (id.setShoppingCartID(cart) != null) {
                isOK = true;
            }
        }
        return shoppingCartService.getItemByID(cart);
    }

    @Override
    public void deleteByID(ShoppingCart cart) {
        shoppingCartService.deleteItem(cart);
    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) {
        shoppingCartService.addProductInCart(product, cart);
    }

    @Override
    public Map getProductList(ShoppingCart cart) {
        return shoppingCartService.getShoppingCartProductList(cart);
    }

    @Override
    public BigDecimal getCartValue(ShoppingCart cart) {
        return shoppingCartService.getShoppingCartTotalValue(cart);
    }

}
