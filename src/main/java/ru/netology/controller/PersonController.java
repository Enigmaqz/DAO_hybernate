package ru.netology.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.PersonService;

import javax.annotation.security.RolesAllowed;
import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    PersonService service;

    public PersonController(PersonService service) {


        this.service = service;
    }

    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Person> getProduct(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Person> getProduct(@RequestParam("age") int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @PostAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/persons/by-name-surname")
    @ResponseBody
    public Optional<Person> getProduct(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/special")
    public String specialUser(String username) {
        return "Hi, special, " + username;
    }


}