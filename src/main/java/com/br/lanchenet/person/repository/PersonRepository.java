package com.br.lanchenet.person.repository;

import com.br.lanchenet.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getOne(Long id);

}
