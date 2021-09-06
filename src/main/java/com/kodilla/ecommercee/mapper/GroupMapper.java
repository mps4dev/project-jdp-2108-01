package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GroupMapper extends EntityMapper<Group, GroupDto> {

    ProductRepository repository;

    @Override
    public Group toEntity(final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                groupDto.getProductsIds().stream()
                        .map(repository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public GroupDto toDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts().stream()
                        .map(Product::getId)
                        .collect(Collectors.toList())
        );
    }
}
