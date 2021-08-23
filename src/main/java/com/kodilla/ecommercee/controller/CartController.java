package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping
    public CartDto create(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/{id}")
    public CartDto get(@PathVariable Long id) {
        return new CartDto();
    }

    @PutMapping
    public CartDto update(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/order")
    public OrderDto order(@RequestBody CartDto cartDto) {
        return new OrderDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

    }
}
