package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id_book) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id_book = ?", new Object[]{id_book}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, data) VALUES(?, ?, ?)", book.getName(), book.getAuthor(), book.getData());
    }

    public void update(int id_book, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, data=? WHERE id_book=?", updatedBook.getName(), updatedBook.getAuthor(),
                updatedBook.getData(), id_book);
    }

    public void delete(int id_book) {
        jdbcTemplate.update("DELETE FROM Book WHERE id_book=?", id_book);
    }


    //Join'им таблицы Book и Person и получаем человека, которому принадлежит книга с указанным id
    public Optional<Person> getBookOwner(int id) {
        //Выбираем все колонки талицы Person из объединенной таблицы
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.id_people = Person.id_people WHERE Book.id_people = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    //Освобождает книгу (этот метод вызывается, когда человек возвращает книгу в библиотеку)
    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET id_people = NULL WHERE id_book = ?", id);
    }

    //Назначает книгу человеку (этот метод вызывается, когда человек забирает книгу из библиотеки)
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET id_people = ? WHERE id_book = ?", selectedPerson.getId_people(), id);
    }



}
