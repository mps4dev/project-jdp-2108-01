package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) throws CreatingObjectWithIdException {
        return service.create(userDto);
    }

    @PutMapping("/{id}/block")
    public void block(@PathVariable long id) throws EntityNotFoundException {
        service.block(id);
    }

    @PutMapping("/{id}/generate")
    public UserKeyDto generateKey(@PathVariable long id) throws EntityNotFoundException {
        return service.generateKey(id);
    }
}
