package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GroupService {

    private final GroupMapper mapper;
    private final GroupRepository repository;

    public List<GroupDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public GroupDto getById(final long id) throws EntityNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException(Group.class, id));
    }

    @Transactional
    public GroupDto create(final GroupDto groupDto) throws CreatingObjectWithIdException {
        if (groupDto.getId() != 0) throw new CreatingObjectWithIdException(Group.class, groupDto.getId());
        return saveAndMapToDto(groupDto);
    }

    @Transactional
    public GroupDto update(final GroupDto groupDto) throws EntityNotFoundException {
        repository.findById(groupDto.getId()).orElseThrow(() -> new EntityNotFoundException(Group.class, groupDto.getId()));
        return saveAndMapToDto(groupDto);
    }

    private GroupDto saveAndMapToDto(final GroupDto groupDto) {
        Group group = repository.save(mapper.toEntity(groupDto));
        return mapper.toDto(group);
    }

    @Transactional
    public void delete(final long id) throws EntityNotFoundException {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Group.class, id));
        repository.deleteById(id);
    }
}
