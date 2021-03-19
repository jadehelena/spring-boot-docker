package com.controller;

import java.util.List;

import com.model.Person;
import com.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
	public List<Person> lista() {
        return repository.findAll();
	}

    @PostMapping
    public Person newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }
}