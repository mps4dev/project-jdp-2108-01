package com.kodilla.ecommercee.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityMapper<ENTITY, DTO> {

    abstract ENTITY toEntity(DTO dto);

    abstract DTO toDto(ENTITY entity);

    public List<DTO> toDtoList(List<ENTITY> list) {
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
