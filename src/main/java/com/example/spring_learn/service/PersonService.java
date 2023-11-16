package com.example.spring_learn.service;

import com.example.spring_learn.exceptions.PersonIsNotExistException;
import com.example.spring_learn.entity.Person;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final JdbcTemplate jdbcTemplate;

   public PersonService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> show() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person index(int id) throws PersonIsNotExistException {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper());
        } catch (EmptyResultDataAccessException exception) {
            throw new PersonIsNotExistException("Человек с таким id не найден");
        }
    }
}
