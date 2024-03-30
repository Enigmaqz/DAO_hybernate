package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.PersonService;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    PersonService service;

    public PersonController(PersonService service) {


        this.service = service;
    }

    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Person> getProduct(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Person> getProduct(@RequestParam("age") int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-name-surname")
    @ResponseBody
    public Optional<Person> getProduct(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

}