package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

            // Обновление данных
//            Person person = session.get(Person.class, 2);
//            person.setName("Bob");

            //Удаление данных
//            Person person = session.get(Person.class, 4);
//            session.delete(person);

            // Добавление в БД
            Person person = new Person("Katy", 40);
            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());
        }
        finally {
            sessionFactory.close();
        }
    }
}
