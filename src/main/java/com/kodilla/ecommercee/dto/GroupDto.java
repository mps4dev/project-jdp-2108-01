package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GroupDto {

    private long id;
    private String name;
    private List<Product> products = new ArrayList<>();
}
