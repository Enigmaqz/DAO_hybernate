package ru.netology.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.entity.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCity(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return repository.findByAgeLessThan(age, Sort.by(Sort.Direction.ASC, "age"));
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}