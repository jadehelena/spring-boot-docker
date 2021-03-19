package com.repository;

import java.util.List;

import com.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

  List<Person> findByLastName(@Param("name") String name);

}