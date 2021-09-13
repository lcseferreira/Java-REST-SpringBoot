package com.lucasferreira.RESTSpringBoot.controllers;

import com.lucasferreira.RESTSpringBoot.data.vo.v1.PersonVOV1;
import com.lucasferreira.RESTSpringBoot.data.vo.v2.PersonVOV2;
import com.lucasferreira.RESTSpringBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person/v1")
public class PersonControllerV1 {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonVOV1>> findAll() {
        List<PersonVOV1> persons = service.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonVOV1> findById(@PathVariable Long id) {
        PersonVOV1 person = service.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<PersonVOV1> create(@RequestBody PersonVOV1 person) {
        PersonVOV1 newPerson = service.create(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping
    public ResponseEntity<PersonVOV1> update(@RequestBody PersonVOV1 person) {
        PersonVOV1 updatePerson = service.update(person);
        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
