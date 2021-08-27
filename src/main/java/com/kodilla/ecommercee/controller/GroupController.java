package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.BadIdException;
import com.kodilla.ecommercee.exception.ObjectAlreadyExistsException;
import com.kodilla.ecommercee.service.GroupService;
import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@RestController
@RequestMapping("v1/group")
public class GroupController {

    private final GroupService service;

    @GetMapping
    public List<GroupDto> get() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GroupDto get(@PathVariable long id) throws BadIdException {
        return service.getById(id);
    }

    @PostMapping
    public GroupDto create(@RequestBody GroupDto groupDto) throws ObjectAlreadyExistsException {
        return service.create(groupDto);
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) throws BadIdException {
        return service.update(groupDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
