package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartDto {

    private long id;
    private List<Product> productsIds;
    private long userId;
}
