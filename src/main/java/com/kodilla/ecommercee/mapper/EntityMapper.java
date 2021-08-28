package com.kodilla.ecommercee.mapper;

import java.util.List;
import java.util.stream.Collectors;

abstract class EntityMapper<ENTITY,DTO> {

    List<DTO> mapFrom(List<ENTITY> list) {
        return list.stream()
                .map(this::mapFrom)
                .collect(Collectors.toList());
    }

    abstract DTO mapFrom(ENTITY entity);

    abstract ENTITY mapTo(DTO dto);

}
