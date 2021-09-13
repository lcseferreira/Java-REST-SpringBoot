package com.lucasferreira.RESTSpringBoot.services;

import com.lucasferreira.RESTSpringBoot.converter.DozerConverter;
import com.lucasferreira.RESTSpringBoot.converter.custom.PersonConverter;
import com.lucasferreira.RESTSpringBoot.data.vo.v1.PersonVOV1;
import com.lucasferreira.RESTSpringBoot.data.vo.v2.PersonVOV2;
import com.lucasferreira.RESTSpringBoot.exceptions.ResourceNotFoundException;
import com.lucasferreira.RESTSpringBoot.data.model.Person;
import com.lucasferreira.RESTSpringBoot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonConverter converter;

    public List<PersonVOV1> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVOV1.class);
    }

    public PersonVOV1 findById(Long id) {
        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerConverter.parseObject(entity, PersonVOV1.class);
    }

    public PersonVOV1 create(PersonVOV1 person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVOV1.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        var entity = converter.convertVOToEntity(person);
        var vo = converter.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonVOV1 update(PersonVOV1 person) {
        var entity = repository.findById(person.getId()).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVOV1.class);

        return vo;
    }
    public void delete(Long id) {
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
