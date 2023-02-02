package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.postgresql.gss.GSSOutputStream;
import org.w3c.dom.ls.LSOutput;

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

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = session.get(Person.class, 1);
//            System.out.println("Получили человека");
//
//            // Получим связанные сущности (Lazy)
//            System.out.println(person.getItems());

            // Получим товар потом получим связанного с ним человека
//            Item item = session.get(Item.class, 1);
//            System.out.println("Получили товар");
//
//            System.out.println(item.getOwner());


//            // Получим человека и товар Eager
//            Person person = session.get(Person.class, 1);
//            System.out.println("Получили человека из таблицы");
//            System.out.println(person);
//
//            System.out.println(person.getItems());
//
//            // В Hibernate есть метод для подгрузки сущности
//            Hibernate.initialize(person.getItems()); // подгружаем связанные ленивые сущности
//
//            session.getTransaction().commit();
//
//            // Вне сессии товары можем получать так как они уже были подгружены
//            System.out.println(person.getItems());
//
//            // При ленивой загрузке мы не можем получать данные вне сессии (Если не будем использовать геттер внутри сессии)

            // Что если необходимо подгрузить человека до сессии и высеси без товаров, а потом где-то в сессии подгрузить товары этого человека
//            Person person = session.get(Person.class, 1);
//            System.out.println("Получили челоека из таблицы");
//
//            session.getTransaction().commit();
//
//            System.out.println("Сессия закончилась (session.clode)");
//            System.out.println("Вне сессии");
//
//            // Открываем новую транзакцию (в любом другом месте в коде)
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            System.out.println("Внутри другой транзакции");
//
//            person = (Person) session.merge(person);
//            Hibernate.initialize(person.getItems());
//
//            session.getTransaction().commit();
//            System.out.println("Вне второй сессии");
//
//            // Это работает так как связанные товары были загружены
//            System.out.println(person.getItems());



            // HQL - код
            Person person = session.get(Person.class, 1);
            System.out.println("Получили челоека из таблицы");

            session.getTransaction().commit();

            System.out.println("Сессия закончилась (session.clode)");
            System.out.println("Вне сессии");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Внутри другой транзакции");
            
            List<Item> items = session.createQuery("select i from Item i where i.owner.id =:personId", Item.class).setParameter("personId", person.getId()).getResultList();

            System.out.println(items);

            session.getTransaction().commit();
            System.out.println("Вне второй сессии");


        }
    }
}
