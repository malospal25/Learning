package ru.nikita.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.springcourse.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    // Поиск по имени
    List<Person> findByName(String name);

    // Поиск по имени и сортировка по возрасту
    List<Person> findByNameOrderByAge(String name);

    // Поиск людей по их email
    List<Person> findByEmail(String email);

    // Поиск людей по начальной букве(либо первы нсколько символов)
    List<Person> findByNameStartingWith(String startingWith);

    // Возвращает людей либо по их имени, либо по их email'у
    List<Person> findByNameOrEmail(String name, String email);
}
