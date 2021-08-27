package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductDto> get() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return new ProductDto();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return new ProductDto();
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return new ProductDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }
}
