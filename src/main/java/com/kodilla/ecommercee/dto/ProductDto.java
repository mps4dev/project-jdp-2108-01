package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDto {

    private long id;
    private Group group;
    private String name;
    private String description;
    private int price;
}
