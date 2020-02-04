package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidation;
import com.javaguru.shoppinglist.service.validation.ProductNameValidation;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidation;

import java.math.BigDecimal;

public class ProductService {

    private ProductRepository repository = new ProductRepository();
    private Long lastAddedProductID = 0L;

    public void insertProduct(Product product) {
        repository.insert(product);
        lastAddedProductID = product.getId();
    }

    public void validateProductName(String name) {
        ProductNameValidation nameValidation = new ProductNameValidation();
        nameValidation.validate(name);
    }

    public void validateProductPrice(BigDecimal price) {
        ProductPriceValidation priceValidation = new ProductPriceValidation();
        priceValidation.validate(price);
    }

    public void validateProductDiscount(BigDecimal discount) {
        ProductDiscountValidation discountValidation = new ProductDiscountValidation();
        discountValidation.validate(discount);
    }

    public Product findByID(Long productID) {
        return repository.findByID(productID);
    }

    public Long getLastAddedProductID() {
        return lastAddedProductID;
    }
}
