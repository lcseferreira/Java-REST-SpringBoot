package com.lucasferreira.RESTSpringBoot.services;

import com.lucasferreira.RESTSpringBoot.exceptions.ResourceNotFoundException;
import com.lucasferreira.RESTSpringBoot.data.model.PersonVO;
import com.lucasferreira.RESTSpringBoot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll() {
        return repository.findAll();
    }

    public PersonVO findById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public PersonVO create(PersonVO person) {
        return repository.save(person);
    }

    public PersonVO update(PersonVO person) {
        PersonVO entity = repository.findById(person.getId()).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }
    public void delete(Long id) {
        PersonVO entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
