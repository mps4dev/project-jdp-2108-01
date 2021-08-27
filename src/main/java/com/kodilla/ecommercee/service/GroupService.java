package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.CreatingObjectWithIdException;
import com.kodilla.ecommercee.exception.NoSuchIdException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupService {

    private final GroupMapper mapper;
    private final GroupRepository repository;

    public List<GroupDto> getAll() {
        return mapper.mapToDtoList(repository.findAll());
    }

    public GroupDto getById(final long id) throws NoSuchIdException {
        Optional<Group> group = repository.findById(id);
        if (group.isPresent()) {
            return mapper.mapToDto(group.get());
        } else {
            throw new NoSuchIdException();
        }
    }

    @Transactional
    public GroupDto create(final GroupDto groupDto) throws CreatingObjectWithIdException {
        if (groupDto.getId() != 0) throw new CreatingObjectWithIdException();
        return saveAndReturn(groupDto);
    }

    @Transactional
    public GroupDto update(final GroupDto groupDto) throws NoSuchIdException {
        Optional<Group> group = repository.findById(groupDto.getId());
        if (group.isPresent()) {
            return saveAndReturn(groupDto);
        } else {
            throw new NoSuchIdException();
        }
    }

    private GroupDto saveAndReturn(final GroupDto groupDto) {
        Group group = repository.save(mapper.mapToGroup(groupDto));
        return mapper.mapToDto(group);
    }

    @Transactional
    public void delete(final long id) {
        repository.deleteById(id);
    }
}
