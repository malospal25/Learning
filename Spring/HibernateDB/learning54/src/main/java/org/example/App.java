package org.example;

import org.example.model.Passport;
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
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Test person", 50);
////            Passport passport = new Passport(person, 12345);
//            // Поле добавления команды в классе Person
//            Passport passport = new Passport(12345);
//
//            person.setPassport(passport);
//
//            session.save(person);

            // Получение паспорта через человека
//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());

            // Получение человека через паспорт
//            Passport passport = session.get(Passport.class, 1);
//            System.out.println(passport.getPerson().getName());
//            System.out.println(passport.getPerson().getAge());

            // Изменим номер папорта у какого-нибудь человека
//            Person person = session.get(Person.class, 1);
//            person.getPassport().setPassportNumber(77777);

            // Удалим человека и посмотрим как каскадно удалится его паспорт (Это при том, что мы не настраивали каскадирование)
            Person person = session.get(Person.class, 2);
            session.remove(person);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
