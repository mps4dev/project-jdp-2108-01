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
        return repository.findById(id).map(mapper::mapToDto).orElseThrow(NoSuchIdException::new);
    }

    @Transactional
    public GroupDto create(final GroupDto groupDto) throws CreatingObjectWithIdException {
        if (groupDto.getId() != 0) throw new CreatingObjectWithIdException();
        return saveAndMapToDto(groupDto);
    }

    @Transactional
    public GroupDto update(final GroupDto groupDto) throws NoSuchIdException {
        boolean isPresent = repository.findById(groupDto.getId()).isPresent();
        if (isPresent) {
            return saveAndMapToDto(groupDto);
        } else {
            throw new NoSuchIdException();
        }
    }

    private GroupDto saveAndMapToDto(final GroupDto groupDto) {
        Group group = repository.save(mapper.mapToGroup(groupDto));
        return mapper.mapToDto(group);
    }

    @Transactional
    public void delete(final long id) throws NoSuchIdException {
        boolean isPresent = repository.findById(id).isPresent();
        if (isPresent) {
            repository.deleteById(id);
        } else {
            throw new NoSuchIdException();
        }
    }
}
