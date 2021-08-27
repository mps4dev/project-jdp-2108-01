package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
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
@RequestMapping("v1/group")
public class GroupController {

    @GetMapping
    public List<GroupDto> get() {
        return new ArrayList<>();
    }

    @GetMapping("/{groupId}")
    public GroupDto get(@PathVariable Long groupId) {
        return new GroupDto();
    }

    @PostMapping
    public GroupDto create(@RequestBody GroupDto groupDto) {
        return groupDto;
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return groupDto;
    }

    @DeleteMapping("/{groupId}")
    public void delete(@PathVariable long groupId) {

    }
}
