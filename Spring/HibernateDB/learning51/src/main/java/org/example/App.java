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

            //Получение владельца товара
//            Item item = session.get(Item.class, 7);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);


            // Добавление товара в таблицу с привязанным к нему владельцем
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person);
//
//            person.getItems().add(newItem);
//
//            session.save(newItem);


            // Добавление человека с единственным товаром
//            Person person = new Person("Test person", 50);
//
//            Item newItem = new Item("Item from Hibernae 2", person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(person);
//            session.save(newItem);


            // Удалить товар у человека
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
//            //SQL
//            for (Item item: items)
//                session.remove(item);
//
//            //Не порождает SQL, но необходимо для того, чтобы к кеше все было верно
//            person.getItems().clear();
//

            // Удалить человека
//            Person person = session.get(Person.class, 5);
//            session.remove(person);
//
//            // В кэше Hibernate тоже сделать null (Было правильное состояние Hibernate кэша)
//            person.getItems().forEach(i -> i.setOwner(null));
//

            // Смена владельца у существующего товара
            Person person = session.get(Person.class, 3);
            Item item = session.get(Item.class, 3);
            Item item1 = session.get(Item.class, 7);

            // У старого владельца этого товара нужно удалить товар
            item.getOwner().getItems().remove(item);
            //

            // Названичение нового владельца товара (Порождает SQL)
            item.setOwner(person);
             
            person.getItems().add(item);

            item1.setOwner(person);
            person.getItems().add(item1);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
