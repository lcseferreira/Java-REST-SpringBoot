package com.lucasferreira.RESTSpringBoot.repositories;

import com.lucasferreira.RESTSpringBoot.data.model.PersonVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
