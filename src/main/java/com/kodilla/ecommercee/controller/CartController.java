package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private final CartService service;

    @PostMapping
    public CartDto create(@RequestBody CartDto cartDto) throws CreatingObjectWithIdException {
        return service.create(cartDto);
    }

    @GetMapping("/{id}")
    public CartDto get(@PathVariable long id) throws EntityNotFoundException {
        return service.getById(id);
    }

    @PutMapping
    public CartDto update(@RequestBody CartDto cartDto) throws EntityNotFoundException {
        return service.update(cartDto);
    }

    @PostMapping("/order")
    public OrderDto order(@RequestBody CartDto cartDto) {
        return service.order(cartDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws EntityNotFoundException {
        service.delete(id);
    }
}
