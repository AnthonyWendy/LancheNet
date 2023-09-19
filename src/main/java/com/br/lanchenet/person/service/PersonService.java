package com.br.lanchenet.person.service;

import com.br.lanchenet.person.entities.Person;
import com.br.lanchenet.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person doPost(Person entity){
        personRepository.save(entity);
        return personRepository.getOne(entity.getId());
    }

    public Person doPut(Person entity){
        personRepository.save(entity);
        return personRepository.getOne(entity.getId());
    }

    public Page<Person> doFindAll(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public Optional<Person> doGetOne(Long id){
        return  personRepository.findById(id);
    }

}
