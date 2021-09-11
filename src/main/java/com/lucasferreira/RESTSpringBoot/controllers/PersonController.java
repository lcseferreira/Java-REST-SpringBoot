package com.lucasferreira.RESTSpringBoot.controllers;

import com.lucasferreira.RESTSpringBoot.data.vo.PersonVO;
import com.lucasferreira.RESTSpringBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonVO>> findAll() {
        List<PersonVO> persons = service.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
        PersonVO person = service.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
        PersonVO newPerson = service.create(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping
    public ResponseEntity<PersonVO> update(@RequestBody PersonVO person) {
        PersonVO updatePerson = service.update(person);
        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
