package ru.nikita.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.nikita.springcourse.models.Item;
import ru.nikita.springcourse.models.Person;
import ru.nikita.springcourse.repositories.ItemsRepositories;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepositories itemsRepositories;


    @Autowired
    public ItemService(ItemsRepositories itemsRepositories) {
        this.itemsRepositories = itemsRepositories;
    }

    public List<Item> findByItemName(String itemName) {
        return itemsRepositories.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner){
        return itemsRepositories.findByOwner(owner);
    }

}
