package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderService service;

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
    public OrderDto create(@RequestBody OrderDto orderDto) throws CreatingObjectWithIdException {
        return service.create(orderDto);
    }
}