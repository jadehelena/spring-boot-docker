package com.controller;

import java.net.URI;
import java.util.List;

import com.model.Person;
import com.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Person> newPerson(@RequestBody Person newPerson, UriComponentsBuilder uriBuilder) {
        repository.save(newPerson);
        URI uri = uriBuilder.path("/persons/{id}").buildAndExpand(newPerson.getId()).toUri();
		return ResponseEntity.created(uri).body(newPerson);
    }
}