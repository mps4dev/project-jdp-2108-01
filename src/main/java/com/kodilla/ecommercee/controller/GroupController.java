package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
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
    public GroupDto get(@PathVariable long id) throws EntityNotFoundException {
        return service.getById(id);
    }

    @PostMapping
    public GroupDto create(@RequestBody GroupDto groupDto) throws CreatingObjectWithIdException {
        return service.create(groupDto);
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) throws EntityNotFoundException {
        return service.update(groupDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws EntityNotFoundException {
        service.delete(id);
    }
}
