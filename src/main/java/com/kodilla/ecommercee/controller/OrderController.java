package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<OrderDto> get() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable long id) throws EntityNotFoundException {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws EntityNotFoundException {
        service.delete(id);
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) throws EntityNotFoundException {
        return service.update(orderDto);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return service.create(orderDto);
    }
}