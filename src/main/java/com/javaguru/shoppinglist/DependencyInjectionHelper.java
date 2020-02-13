package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.UIMenu;
import com.javaguru.shoppinglist.console.service.ProductUIService;
import com.javaguru.shoppinglist.console.service.ShoppingCartUIService;
import com.javaguru.shoppinglist.console.service.UIService;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CRUD;
import com.javaguru.shoppinglist.repository.MainRepository;
import com.javaguru.shoppinglist.repository.ShoppingCart;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.RepositoryItemService;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.ShoppingCartValidationService;
import com.javaguru.shoppinglist.service.validation.ValidationService;

import java.util.HashMap;
import java.util.Map;


class DependencyInjectionHelper {

    // создавать все валидационные рулы и классы-сеттеры консоли тоже? консоль от них зависит.


    private Map<Long, Product> productRepository = new HashMap<>();
    private Map<Long, ShoppingCart> shoppingCartRepository = new HashMap<>();

    private CRUD dataBase = new MainRepository(productRepository, shoppingCartRepository);

    private RepositoryItemService<Product> productService = new ProductService(dataBase);

    private RepositoryItemService<ShoppingCart> shoppingCartService = new ShoppingCartService(dataBase);

    private ValidationService<Product> productValidationService = new ProductValidationService(productRepository);

    private ValidationService<ShoppingCart> shoppingCartValidationService = new ShoppingCartValidationService();

    private UIService<Product> productServiceUI = new ProductUIService(productService, productValidationService);

    private UIService<ShoppingCart> shoppingCartServiceUI = new ShoppingCartUIService(shoppingCartService, shoppingCartValidationService);

    UIMenu createApplication() {
        return new UIMenu(productService, shoppingCartService, productServiceUI, shoppingCartServiceUI);
    }
}
