package com.example.springlearn.service;

import com.example.springlearn.models.Mood;
import com.example.springlearn.models.Person;
import com.example.springlearn.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setMood(Mood.valueOf("CALM"));
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> findByNameOrderByAge(String name) {
        return personRepository.findByNameOrderByAge(name);
    }

    public List<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
