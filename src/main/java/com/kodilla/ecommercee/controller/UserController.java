package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping("/block/{id}")
    public void block(@PathVariable long id) {
    }

    @PutMapping("/generate/{id}")
    public UserKeyDto generateKey(@PathVariable long id) {
        return new UserKeyDto();
    }
}
