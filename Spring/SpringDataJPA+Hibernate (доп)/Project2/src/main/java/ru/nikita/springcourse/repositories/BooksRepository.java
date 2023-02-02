package ru.nikita.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikita.springcourse.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String title);
}
