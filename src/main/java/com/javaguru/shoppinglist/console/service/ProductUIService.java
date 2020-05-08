package com.javaguru.shoppinglist.console.service;

import com.javaguru.shoppinglist.console.input.*;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.RepositoryItemService;
import com.javaguru.shoppinglist.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductUIService implements UIService<Product> {

    private final RepositoryItemService<Product> productService;
    private final ValidationService<Product> productValidationRules;

    @Autowired
    public ProductUIService(RepositoryItemService<Product> productService,
                            ValidationService<Product> productValidationRules) {

        this.productService = productService;
        this.productValidationRules = productValidationRules;
    }

    @Override
    public Product insert() throws ExitException {
        Product product = create();
        productService.insert(product);
        return product;
    }

    @Override
    public Product create() throws ExitException {
        Product product = new Product();
        validateAndSetName(product);
        validateAndSetPrice(product);
        validateAndSetDiscount(product);
        return product;
    }

    @Override
    public Product getByID() throws ExitException {
        Product product = new Product();
        SetProductID id = new SetProductID();
        boolean isOK = false;
        while (!isOK) {
            if (id.setProductID(product) != null) {
                isOK = true;
            }
        }
        return productService.getByID(product);
    }

    private void validateAndSetName(Product product) throws ExitException {
        SetProductName name = new SetProductName();
        boolean isOK = false;
        while (!isOK) {
            name.setProductName(product);
            isOK = productValidationRules.validateName(product);
        }
    }

    private void validateAndSetPrice(Product product) throws ExitException {
        SetProductPrice price = new SetProductPrice();
        boolean isOK = false;
        while (!isOK) {
            price.setProductPrice(product);
            isOK = productValidationRules.validatePrice(product);
        }
    }

    private void validateAndSetDiscount(Product product) throws ExitException {
        SetProductDiscount discount = new SetProductDiscount();
        boolean isOK = false;
        while (!isOK) {
            discount.setProductDiscount(product);
            isOK = productValidationRules.validateDiscount(product);
        }
    }

    @Override
    public void deleteByID(Product object) throws ExitException {

    }

    @Override
    public void addProductToCart(Product product, ShoppingCart cart) throws ExitException {

    }

    @Override
    public List<Product> getProductList(ShoppingCart cart) throws ExitException {
        return null;
    }

    @Override
    public BigDecimal getCartValue(ShoppingCart cart) throws ExitException {
        return null;
    }
}
