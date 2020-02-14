package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ValidationRules;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {


    @Mock
    private Map<Long, Product> productRepository;

    @InjectMocks
    private ProductValidationService victim;

    @Test
    public void testNegativeValidateItemName() {
        ValidationRules itemName = new ProductNameValidationRule(productRepository);

    }

    @Test
    public void validateItemPrice() {
    }

    @Test
    public void validateItemDiscount() {
    }
}