package com.TestCaseTesting.repository;

import com.TestCaseTesting.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByCountryName(String country);
}
