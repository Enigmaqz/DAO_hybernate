package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.entity.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}