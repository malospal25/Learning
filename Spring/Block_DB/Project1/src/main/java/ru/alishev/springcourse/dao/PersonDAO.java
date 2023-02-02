package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id_people) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id_people = ?", new Object[]{id_people}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(fullname, data) VALUES(?, ?)", person.getFullName(), person.getData());
    }

    public void update(int id_people, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET fullName=?, data=? WHERE id_people=?", updatedPerson.getFullName(),
                updatedPerson.getData(), id_people);
    }

    public void delete(int id_people) {
        jdbcTemplate.update("DELETE FROM person WHERE id_people=?", id_people);
    }

    // Для валидации уникальности ФИО
    public Optional<Person> getPersonByFullName(String fullName){
        return jdbcTemplate.query("SELECT * FROM person WHERE fullname=?", new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    // Здесь Join не нужен. И так уже получили человека с помощью отдельного метода
    public List<Book> getBooksPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id_people = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
