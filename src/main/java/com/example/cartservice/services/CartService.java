package com.example.cartservice.services;

import com.example.cartservice.model.Cart;

import java.util.List;

public interface CartService {
    // getting allCarts
    List<Cart> getAllCarts();


    // getting a single cart
    Cart getCart(long id);

    // get in date range

    List<Cart> getCartByDate(String date);

    // get user cart

    List<Cart> getUserCart(long userId);

    // add a new cart

    Cart addCart(Cart cart);

    // update a cart

    Cart updateCart(Cart cart);

    // delete a cart

    Cart deleteCart(long id);

}
