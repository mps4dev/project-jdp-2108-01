package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
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

    @GetMapping(value = "/{groupId}")
    public GroupDto get(@PathVariable Long groupId) {
        return new GroupDto();
    }

    @PostMapping
    public void add(@RequestBody GroupDto groupDto) {

    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return groupDto;
    }

    @DeleteMapping
    public void delete(@RequestBody GroupDto groupDto) {

    }
}
