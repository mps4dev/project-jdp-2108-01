package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public void get(){}

    @GetMapping({"/{id}"})
    public void get(@PathVariable Long id){}

    @PostMapping
    public void create(){}

    @PutMapping("/{product}")
    public void update(@PathVariable String product){}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){}

}
