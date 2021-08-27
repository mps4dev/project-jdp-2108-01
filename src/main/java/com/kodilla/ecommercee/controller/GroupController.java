package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public void delete(@RequestBody GroupDto groupDto) {

    }
}
