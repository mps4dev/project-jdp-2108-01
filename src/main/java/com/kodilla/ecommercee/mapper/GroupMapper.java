package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.stereotype.Service;

@Service
public class GroupMapper extends EntityMapper<Group, GroupDto> {

    @Override
    public Group toEntity(final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                groupDto.getProducts()
        );
    }

    @Override
    public GroupDto toDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts()
        );
    }
}
