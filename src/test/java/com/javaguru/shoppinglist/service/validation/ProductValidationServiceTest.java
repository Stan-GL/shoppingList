package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    private Product product = new Product();

    ProductNameValidationRule mock = mock(ProductNameValidationRule.class);

//    private ProductValidationService victim;

    @Test
    public void testNegativeValidateItemName() {
//        when(mock.validateItemName(product)).thenReturn(false);

        verify(mock).validate(product);
//        assertFalse(result);
    }

    @Test
    public void validateItemPrice() {
    }

    @Test
    public void validateItemDiscount() {
    }
}