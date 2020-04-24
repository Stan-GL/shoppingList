package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("nameValidation")
public class ProductNameValidationRule implements ValidationRules<Product> {

    private final CRUD mainRepository;

    @Autowired
    public ProductNameValidationRule(CRUD mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public boolean validate(Product product) {
        checkNotNull(product);
        int name = product.getProductName().replaceAll(" ", "").length();
        if (name < 3 || name > 32) {
            System.out.println("Name must contain 3-32 symbols!");
            return false;
        } else {
            return validateExclusiveness(product);
        }
    }

    private boolean validateExclusiveness(Product product) {
        checkNotNull(product);
        if (!mainRepository.ifProductExistsByName(product)) {
            System.out.println("Product name already exists, choose another name.");
            return false;
        }
        return true;
    }

}

