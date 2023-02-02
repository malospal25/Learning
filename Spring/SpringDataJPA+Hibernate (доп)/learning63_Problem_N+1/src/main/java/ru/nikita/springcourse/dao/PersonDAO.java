package ru.nikita.springcourse.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.nikita.springcourse.models.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);

        // При получении нескольких людей, данный код считается нормальным, но если людей будет 1млн. Будет запрашиваться N запросов к БД
//        // 1 Запрос
//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//
//        // N запросов
//        for (Person person : people)
//            System.out.println("Person " + person.getName() + " has " + person.getItems());

        // Необходимо оптимизировать данный код
        // Solution
        // SQL: A LEFT JOIN B -> Результирующая таблица

        // В List записи дублируются
//        List<Person> people = session.createQuery("SELECT p from Person p LEFT JOIN FETCH p.items").getResultList();
        // В Set у нас нету дубликатов
        Set<Person> people = new HashSet<Person>(session.createQuery("SELECT p from Person p LEFT JOIN FETCH p.items").getResultList());

        for (Person person : people){
            System.out.println("Person " + person.getName() + " has " + person.getItems());
        }

    }

}
