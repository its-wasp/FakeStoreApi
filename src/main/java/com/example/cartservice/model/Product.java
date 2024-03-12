package com.example.cartservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter


public class Product {
    private long productId;
    private long quantity;
}
