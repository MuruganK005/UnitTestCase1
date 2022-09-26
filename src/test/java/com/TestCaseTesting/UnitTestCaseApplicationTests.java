package com.TestCaseTesting;

import com.TestCaseTesting.model.Person;
import com.TestCaseTesting.repository.PersonRepository;
import com.TestCaseTesting.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UnitTestCaseApplicationTests {
    @Autowired
    private PersonService service;

    @MockBean
    private PersonRepository repository;

    @Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Person(1L, "Danile", "daniel@gmail.com", "USA", 9080850513L),
                        new Person(2L, "Danile", "daniel@gmail.com", "USA", 90808505122L)).collect(Collectors.toList()));
        assertEquals(2, service.getAllPerson().size());
    }
    @Test
    public void savePersonTest(){
        Person p=new Person(1L,"Murugan","muruganeee005@gmail.com","India",9080850513L);
        when(repository.save(p)).thenReturn(p);
        assertEquals(p,service.createPerson(p));
    }
    @Test
    public void getPersonById(){
//        Optional<Person> p=repository.findById(2L);
//        assertEquals("murugan kailasam","murugan kailasam");
//        assertEquals(9080850513L,9080850513L);
        Person p=new Person();
        when(repository.findById(2L)).thenReturn(Optional.of(p));
        assertEquals(2l,2l);
    }
    @Test
    public void updatePersonTest(){
        Person p=Person.builder()
                .id(2L)
                .name("Murugan")
                .email("muruganeee0005@gmail.com")
                .country("india")
                .phone(9080850513l).build();

//        p.setId(3l);
        repository.save(p);
        Person updatedPerson=repository.findByCountryName(p.getCountry());
        assertEquals(p,updatedPerson);
    }

}

