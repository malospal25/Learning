package ru.nikita.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.springcourse.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
