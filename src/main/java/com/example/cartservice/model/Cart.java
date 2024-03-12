package com.example.cartservice.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Cart {
    private long id;
    private long userId;
    private String date;
    private List<Product> products;

}
