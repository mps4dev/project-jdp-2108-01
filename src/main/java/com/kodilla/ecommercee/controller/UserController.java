package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping("/block/{id}")
    public void block(@PathVariable Long id) {

    }
    @PutMapping("/generate/{id}")
    public UserKeyDto generateKey(@PathVariable Long id) {
        return new UserKeyDto();

    }

}
