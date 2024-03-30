package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


    List<Person> findByCity (String city);

    List<Person> findByAgeLessThan (int age, Sort sort);

    Optional<Person> findByNameAndSurname (String name, String surname);
}