package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping
    public List<OrderDto> get() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) {
        return new OrderDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }
}
