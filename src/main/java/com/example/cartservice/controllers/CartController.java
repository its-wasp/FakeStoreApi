package com.example.cartservice.controllers;

import com.example.cartservice.model.Cart;
import com.example.cartservice.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Cart getSingleCart(@PathVariable String id){
        return cartService.getCart(Long.parseLong(id));
    }

    @GetMapping("/date/{date}") // not working yet
    public List<Cart> getCartByDate(@PathVariable String date){
        return cartService.getCartByDate(date);
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getUserCart(@PathVariable String userId){
        return cartService.getUserCart(Long.parseLong(userId));
    }

    @PostMapping("")
    public Cart addCart(@RequestBody Cart cart){
        System.out.println("Cart added successfully");
        return cartService.addCart(cart);
    }

    @PutMapping("")
    public Cart updateCart(@RequestBody Cart cart){
        cartService.updateCart(cart);
        System.out.println("Cart updated");

        return cart;
    }

    @DeleteMapping("/{id}")
    public  Cart deleteCart(@PathVariable String id){

        System.out.println("Cart deleted");

        return cartService.deleteCart(Long.parseLong(id));


    }


}
