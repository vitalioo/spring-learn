package com.example.springlearn.repositories;

import com.example.springlearn.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByNameOrderByAge(String name);
    List<Person> findByEmail(String email);
    Optional<Person> findByName(String username);
}
