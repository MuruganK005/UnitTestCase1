package com.TestCaseTesting.controller;

import com.TestCaseTesting.model.Person;
import com.TestCaseTesting.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody Person person){
        return service.createPerson(person);
    }
    @GetMapping("/getById/{id}")
    public Optional<Person> getByIdPerson(@PathVariable Long id){
        return service.getByIdPerson(id);
    }
    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){
        return service.getAllPerson();
    }
    @PutMapping("/EditPersonById/{id}")
    public Person editPerson(@PathVariable Long id,@RequestBody Person person){
        return service.editByIdPerson(id,person);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteByIdPerson(@PathVariable Long id){
        return service.deleteByIdPerson(id);
    }
    @DeleteMapping("/deleteAllPerson")
    public String deleteAllPerson(){
        return service.deleteAllPerson();
    }
}
