package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping
    public UserDto block(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping
    public UserDto generateKey(@RequestBody UserDto userDto) {
        return userDto;
    }


}
