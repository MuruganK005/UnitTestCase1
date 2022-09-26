package com.TestCaseTesting.service;

import com.TestCaseTesting.model.Person;
import com.TestCaseTesting.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository repository;
    @Override
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Optional<Person> getByIdPerson(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return repository.findAll();
    }
    @Override
    public Person editByIdPerson(Long id, Person person) {
        Optional<Person> person1=repository.findById(id);
        return repository.save(person);
    }

    @Override
    public String deleteByIdPerson(Long id) {
        repository.deleteById(id);
        return id+" Id deleted Successfully";
    }

    @Override
    public String deleteAllPerson() {
        repository.deleteAll();
        return "All Persons are Deleted Successfully";
    }
}
