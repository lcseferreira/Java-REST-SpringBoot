package com.lucasferreira.RESTSpringBoot.repositories;

import com.lucasferreira.RESTSpringBoot.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
