package com.example.springlearn.service;

import com.example.springlearn.models.Person;

import java.util.List;

public interface PersonService {
    Person findOne(int id);

    List<Person> findAll();

    void save(Person person);

    void update(int id, Person person);

    void delete(int id);
}
