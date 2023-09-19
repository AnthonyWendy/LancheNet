package com.br.lanchenet.person.controller;

import com.br.lanchenet.person.entities.Person;
import com.br.lanchenet.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public ResponseEntity<Page<Person>> findAll(Pageable pageable){
        return ResponseEntity.ok(personService.doFindAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getOne(@PathVariable Long id){
        Optional<Person> search = personService.doGetOne(id);
        return ResponseEntity.accepted().body(search);
    }

    @PostMapping("/")
    public ResponseEntity<Person> postEntity(@RequestBody Person entity){
        Person category = personService.doPost(entity);
        return ResponseEntity.accepted().body(category);
    }

    @PutMapping("/")
    public ResponseEntity<Person> putEntity(@RequestBody Person entity){
        Person update = personService.doPut(entity);
        return ResponseEntity.accepted().body(update);
    }
}

