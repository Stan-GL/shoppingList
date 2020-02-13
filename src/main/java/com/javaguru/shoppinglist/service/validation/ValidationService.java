package com.javaguru.shoppinglist.service.validation;

public interface ValidationService<T> {

    boolean validateItemName(T object);

    boolean validateItemPrice(T object);

    boolean validateItemDiscount(T object);

}
