package ru.nikita.springcourse.FirstRESTApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.springcourse.FirstRESTApp.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
