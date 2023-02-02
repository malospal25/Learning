package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Создание и связывание человека и товара (более точный способ)
//            Person person = new Person("Alex", 25);
//            Item item = new Item("Macbook", person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));


            // Создание и связывания человека и товара (более простой способ)
            Person person = new Person("Alex", 25);
            person.addItem(new Item("Macbook1"));
            person.addItem(new Item("Macbook2"));
            person.addItem(new Item("Macbook3"));

            //session.persist(person);
            session.save(person);

            // Код для работы с Hibernate здесь

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
