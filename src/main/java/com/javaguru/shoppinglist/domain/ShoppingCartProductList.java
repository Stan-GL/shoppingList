package com.javaguru.shoppinglist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart_product_list")
public class ShoppingCartProductList {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Id
    @Column(name = "shopping_cart_id")
    private String shoppingCartId;

    @Override
    public String toString() {
        return "ShoppingCartProductList{" +
                "productId=" + productId +
                ", shoppingCartId='" + shoppingCartId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartProductList that = (ShoppingCartProductList) o;
        return productId.equals(that.productId) &&
                shoppingCartId.equals(that.shoppingCartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, shoppingCartId);
    }
}
