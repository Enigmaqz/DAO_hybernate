package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.entity.Person;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonRepository implements CommandLineRunner {
    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Person vova = Person.builder()
                .name("Vova")
                .surname("Petrov")
                .age(15)
                .city("Moscow")
                .phone_number("929292")
                .build();
        manager.persist(vova);
    }


    public List<Person> getPersonsByCity(String city) {
        return manager.createQuery("SELECT p FROM Person p WHERE p.city = :city")
                .setParameter("city", city).getResultList();
    }
}