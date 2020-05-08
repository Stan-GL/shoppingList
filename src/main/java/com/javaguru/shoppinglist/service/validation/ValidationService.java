package com.javaguru.shoppinglist.service.validation;

public interface ValidationService<T> {

    boolean validateName(T object);

    boolean validatePrice(T object);

    boolean validateDiscount(T object);

}
