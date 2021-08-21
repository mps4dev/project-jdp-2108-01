package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @GetMapping
    public List<CartDto> get() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public CartDto get(@PathVariable Long id) {
        return new CartDto();
    }

    @PutMapping
    public CartDto update(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @PostMapping
    public CartDto create(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }
}
