package com.TestCaseTesting.service;

import com.TestCaseTesting.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person createPerson(Person person);

    Optional<Person> getByIdPerson(Long id);

    List<Person> getAllPerson();

    Person editByIdPerson(Long id, Person person);

    String deleteByIdPerson(Long id);

    String deleteAllPerson();
}
