package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.*;

import java.util.Map;

public class ProductValidationService implements ValidationService<Product> {

    private Map<Long, Product> productRepository;

    public ProductValidationService(Map<Long, Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean validateItemName(Product product) {
        ValidationRules<Product> itemName = new ProductNameValidationRule(productRepository);
        return (itemName.validate(product));
    }

    @Override
    public boolean validateItemPrice(Product product) {
        ValidationRules<Product> itemPrice = new ProductPriceValidationRule();
        return itemPrice.validate(product);
    }

    @Override
    public boolean validateItemDiscount(Product product) {
        ValidationRules<Product> itemDiscountRange = new ProductDiscountRangeValidationRule();
        ValidationRules<Product> itemDiscountPriceDependency = new ProductDiscountOnPriceValidationRule();
        return (itemDiscountRange.validate(product) && itemDiscountPriceDependency.validate(product));
    }


}
