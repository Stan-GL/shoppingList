package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidation;
import com.javaguru.shoppinglist.service.validation.ProductNameValidation;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidation;


public class ProductService {

    private ProductRepository repository = new ProductRepository();
    private Long lastAddedProductID = 0L;

    public void insertProduct(Product product) {
        repository.insert(product);
        lastAddedProductID = product.getId();
    }

    public void validateProductName(Product product) {
        ProductNameValidation nameValidation = new ProductNameValidation();
        nameValidation.validate(product);
        if (!repository.findByName(product.getName())) {
            throw new IllegalArgumentException("Product already exists, choose another name.");
        }
    }

    public void validateProductPrice(Product product) {
        ProductPriceValidation priceValidation = new ProductPriceValidation();
        priceValidation.validate(product);
    }

    public void validateProductDiscount(Product product) {
        ProductDiscountValidation discountValidation = new ProductDiscountValidation();
        discountValidation.validate(product);
    }

    public Product findByID(Long productID) {
        return repository.findByID(productID);
    }

    public Long getLastAddedProductID() {
        return lastAddedProductID;
    }
}
