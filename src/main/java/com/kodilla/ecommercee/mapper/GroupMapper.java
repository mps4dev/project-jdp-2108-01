package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                groupDto.getProducts()
        );
    }

    public GroupDto mapToDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts()
        );
    }

    public List<GroupDto> mapToDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
