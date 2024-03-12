package com.example.cartservice.services;

import com.example.cartservice.dto.DtoCart;
import com.example.cartservice.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class FakeStoreCartService implements CartService{


    private final String url = "https://fakestoreapi.com/carts";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Cart> getAllCarts() {
        // getting all carts
        List<DtoCart> dtoCarts = List.of(Objects.requireNonNull(restTemplate.getForObject(url, DtoCart[].class)));

        return mapToCart(dtoCarts);


    }

    // making the mapToCart function

    private List<Cart> mapToCart(List<DtoCart> dtoCarts){
        List<Cart> carts = new ArrayList<>();

        for(DtoCart dtoCart : dtoCarts){
            carts.add(mapCart(dtoCart));
        }

        return carts;
    }

    // creating mapCart function

    private Cart mapCart(DtoCart dtoCart){
        Cart cart = new Cart();
        cart.setId(dtoCart.getId());
        cart.setUserId(dtoCart.getUserId());
        cart.setDate(dtoCart.getDate());
        cart.setProducts(dtoCart.getProducts());

        return cart;
    }

    @Override
    public Cart getCart(long id) {
        // getting a single cart

        DtoCart dtoCart = restTemplate.getForObject(url + "/" + id, DtoCart.class);

        assert dtoCart != null;

        return mapCart(dtoCart);
    }

    @Override
    public List<Cart> getCartByDate(String date) {
        // getting cart by date
        // 'https://fakestoreapi.com/carts?startdate=2019-12-10&enddate=2020-10-10'
        List<DtoCart> dtoCarts = List.of(Objects.requireNonNull(restTemplate.getForObject(url + "?startdate=" + date + "&enddate=" + date, DtoCart[].class)));

        return mapToCart(dtoCarts);

    }

    @Override
    public List<Cart> getUserCart(long userId) {
        // getting user Cart
        List<DtoCart> dtoCarts = List.of(Objects.requireNonNull(restTemplate.getForObject(url + "/user/" + userId, DtoCart[].class)));

        return mapToCart(dtoCarts);
    }

    // making mapToDtoCart function

    private List<DtoCart> mapToDtoCart(List<Cart> carts){
        List<DtoCart> dtoCarts = new ArrayList<>();

        for(Cart cart : carts){
            dtoCarts.add(mapDtoCart(cart));
        }

        return dtoCarts;
    }

    // making mapDtoCart function

    private DtoCart mapDtoCart(Cart cart){
        DtoCart dtoCart = new DtoCart();
        dtoCart.setId(cart.getId());
        dtoCart.setUserId(cart.getUserId());
        dtoCart.setDate(cart.getDate());
        dtoCart.setProducts(cart.getProducts());

        return dtoCart;
    }
    @Override
    public Cart addCart(Cart cart) {
        // adding Cart
        DtoCart dtoCart = restTemplate.postForObject(url, mapDtoCart(cart), DtoCart.class);
        assert dtoCart != null;

        return mapCart(dtoCart);

    }

    @Override
    public Cart updateCart(Cart cart) {
        // updating the cart

        restTemplate.put(url + "/" + cart.getId(), mapDtoCart(cart));

        return cart;
    }

    @Override
    public Cart deleteCart(long id) {
        // delete cart
        Cart cart = getCart(id);
        restTemplate.delete(url + "/" + id);

        return cart;
    }
}
