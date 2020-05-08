package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoppingCarts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCartDTO cartDTO) {
        ShoppingCart cart = new ShoppingCart();
        cart.setCartName(cartDTO.getCartName());
        shoppingCartService.insert(cart);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{cartId}")
    public ShoppingCartDTO getShoppingCartById(@PathVariable("cartId") Long id) {
        ShoppingCart cart = new ShoppingCart(id);
        ShoppingCart result = shoppingCartService.getByID(cart);
        return new ShoppingCartDTO(result);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShoppingCartByID(@PathVariable("cartId") Long id) {
        ShoppingCart cart = new ShoppingCart(id);
        shoppingCartService.delete(cart);
    }


}
