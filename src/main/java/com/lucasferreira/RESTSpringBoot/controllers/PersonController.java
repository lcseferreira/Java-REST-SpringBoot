package com.lucasferreira.RESTSpringBoot.controllers;

import com.lucasferreira.RESTSpringBoot.model.Person;
import com.lucasferreira.RESTSpringBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = service.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person newPerson = service.create(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        Person updatePerson = service.update(person);
        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
