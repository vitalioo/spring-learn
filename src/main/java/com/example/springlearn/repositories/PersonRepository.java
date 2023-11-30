package com.example.springlearn.repositories;

import com.example.springlearn.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByNameOrderByAge(String name);

    List<Person> findByEmail(String email);
}
