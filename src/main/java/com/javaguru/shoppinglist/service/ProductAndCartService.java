package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidation;
import com.javaguru.shoppinglist.service.validation.ProductNameValidation;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidation;
import com.javaguru.shoppinglist.service.validation.ShoppingCartNameValidation;

import java.math.BigDecimal;
import java.util.Map;


public class ProductAndCartService {

    private ProductRepository repository = new ProductRepository();
    private Long lastAddedProductID = 0L;
    private Long lastAddedShoppingCartID = 0L;

    public void insertProduct(Product product) {
        repository.insertProduct(product);
        lastAddedProductID = product.getId();
    }

    public void insertShoppingCart(ShoppingCart cart) {
        repository.insertShoppingCart(cart);
        lastAddedShoppingCartID = cart.getId();
    }

    public void addProductToCart(Product product, ShoppingCart cart) {
        repository.findShoppingCart(cart.getId()).insert(product);
    }

    public void deleteShoppingCart(ShoppingCart cart) {
        repository.deleteShoppingCart(cart);
    }

    public boolean validateProductName(Product product) {
        ProductNameValidation nameValidation = new ProductNameValidation();
        return ((nameValidation.validate(product)) &&
                (nameValidation.validateIfNameExclusive(product, repository.getProductRepository())));
    }

    public boolean validateCartName(ShoppingCart cart) {
        ShoppingCartNameValidation nameValidation = new ShoppingCartNameValidation();
        return nameValidation.validate(cart);
    }

    public boolean validateProductPrice(Product product) {
        ProductPriceValidation priceValidation = new ProductPriceValidation();
        return priceValidation.validate(product);
    }

    public boolean validateProductDiscount(Product product) {
        ProductDiscountValidation discountValidation = new ProductDiscountValidation();
        return (discountValidation.validateDiscountRange(product) &&
                discountValidation.validatePriceDependency(product));
    }

    public Product findProductByID(Long productID) {
        return repository.findProductByID(productID);
    }

    public ShoppingCart findCartByID(Long cartID) {
        return repository.findShoppingCart(cartID);
    }

    public Long getLastAddedProductID() {
        return lastAddedProductID;
    }

    public Long getLastAddedShoppingCartID() {
        return lastAddedShoppingCartID;
    }

    public Map getShoppingCartProductList(Long id) {
        return repository.findShoppingCart(id).getProductList();
    }

    public BigDecimal getProductListTotalValue(ShoppingCart cart) {
        BigDecimal price = new BigDecimal("0");
        for (Map.Entry<Long, Product> entry : cart.getProductList().entrySet()) {
            price = price.add(entry.getValue().getPrice());
        }
        return price;
    }
}
