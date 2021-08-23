package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductDto> get(){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id){
        return new ProductDto();
    }

    @PostMapping("/{productDto}")
    public void create(@PathVariable ProductDto productDto){}

    @PutMapping("/{productDto}")
    public ProductDto update(@PathVariable ProductDto productDto){
        return new ProductDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){}

}
