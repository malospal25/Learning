package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Выводит всю таблицу
//            List<Person> people = session.createQuery("FROM Person").getResultList();
            // Выводит список людей у которых возраст больше 30
//            List<Person> people = session.createQuery("FROM Person where age > 30").getResultList();
            // Выводит список людей у которых имя начинается на K (% - любое количество символов.
//            List<Person> people = session.createQuery("FROM Person where name like 'K%'").getResultList();
//            for(Person person: people){
//                System.out.println(person);
//            }
            //Для тех людей у которых возраст меньше 32 переименновываем в Test
//            session.createQuery("update Person set name = 'Test' where age < 32").executeUpdate();
            // Удаляем людей у которых возраст меньше 31
            session.createQuery("delete from Person where age < 31").executeUpdate();


            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
