package ru.nikita.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.springcourse.models.Item;
import ru.nikita.springcourse.models.Person;

import java.util.List;

@Repository
public interface ItemsRepositories extends JpaRepository<Item, Integer> {
    // Будет искать товары по их названию
    List<Item> findByItemName(String itemName);

    // Этот метод будет искать товары по владельцу
    List<Item> findByOwner(Person owner);
}
