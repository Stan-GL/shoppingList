package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.ValidationRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductValidationService implements ValidationService<Product> {

    private final ValidationRules name;
    private final ValidationRules priceDependency;
    private final ValidationRules discountRange;
    private final ValidationRules price;

    @Autowired
    public ProductValidationService(@Qualifier("nameValidation") ValidationRules nameValidation,
                                    @Qualifier("discountOnPriceValidation") ValidationRules discountOnPriceValidation,
                                    @Qualifier("discountRangeValidation") ValidationRules discountRangeValidation,
                                    @Qualifier("priceValidation") ValidationRules priceValidation) {
        this.name = nameValidation;
        this.priceDependency = discountOnPriceValidation;
        this.discountRange = discountRangeValidation;
        this.price = priceValidation;
    }

    @Override
    public boolean validateItemName(Product product) {
        return (name.validate(product));
    }

    @Override
    public boolean validateItemPrice(Product product) {
        return price.validate(product);
    }

    @Override
    public boolean validateItemDiscount(Product product) {
        return (discountRange.validate(product) && priceDependency.validate(product));
    }


}
