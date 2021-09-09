package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
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
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> get() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable long id) throws EntityNotFoundException {
        return service.getById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) throws CreatingObjectWithIdException {
        return service.create(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) throws EntityNotFoundException {
        return service.update(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws EntityNotFoundException {
        service.delete(id);
    }
}
