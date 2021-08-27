package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.NoSuchIdException;
import com.kodilla.ecommercee.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private OrderService service;

    @GetMapping
    public List<OrderDto> get() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) throws NoSuchIdException {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws NoSuchIdException {
        service.delete(id);
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) throws NoSuchIdException {
        return service.update(orderDto);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return service.create(orderDto);
    }
}
