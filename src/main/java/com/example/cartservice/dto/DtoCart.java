package com.example.cartservice.dto;

import com.example.cartservice.model.Product;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class DtoCart {
    // making a dto cart
    private long id;
    private long userId;

    private String date;

    private List<Product> products;
}
