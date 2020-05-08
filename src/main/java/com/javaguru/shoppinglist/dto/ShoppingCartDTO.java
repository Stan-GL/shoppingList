package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.List;

public class ShoppingCartDTO {

    private Long cartId;
    private String cartName;
    private List<Product> productList;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long cartId, String cartName) {
        this.cartId = cartId;
        this.cartName = cartName;
    }

    public ShoppingCartDTO(ShoppingCart cart) {
        this.cartId = cart.getCartId();
        this.cartName = cart.getCartName();
        this.productList = cart.getProductList();
    }

    public Long getCartId() {
        return cartId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }
}
