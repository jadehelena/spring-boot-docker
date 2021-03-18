package com.repository;

import java.util.List;

import com.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

  List<Person> findByLastName(@Param("name") String name);

}