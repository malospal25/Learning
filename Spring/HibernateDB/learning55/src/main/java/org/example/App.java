package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Добавим новый фильм и у фильма будет два актера
//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harley Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

            //Вывод списка актеров для какого-нибудь фильма
//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());

            //Вывод списка фильмов с этим актером
//            Actor actor = session.get(Actor.class, 1);
//            System.out.println(actor.getMovies());

            // Добавление фильма для существующего актера
//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

            // Удалим фильм у существующего актера
            // Получаем актера по id
            Actor actor = session.get(Actor.class, 2);
            // Выводим для него список фильмов
            System.out.println(actor.getMovies());

            // Получаем тот фильм из списка фильмов который мы хотим удалить
            Movie movieToRemove = actor.getMovies().get(0);

            // На этом его списке фильмов мы вызываем метод remove и удаляэт этот фильм с индексом 0
            actor.getMovies().remove(0);
            // Удаляем с двух сторон
            movieToRemove.getActors().remove(actor);


            session.getTransaction().commit();
        }
    }
}
