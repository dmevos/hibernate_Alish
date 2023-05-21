package ru.osipov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.osipov.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            1/ Посмотрим в таблице Person некоторые данные: //////////
            /////////////////////////////////////////////////////////

//            2/ Добавим в таблицу Person навые данные: //////////
//            Person person1 = new Person("Test1", 15);
//            Person person2 = new Person("Test2", 25);
//            Person person3 = new Person("Test3", 35);
//            session.persist(person1);
//            session.persist(person2);
//            session.persist(person3);


//            3/ Изменим в таблице Person некоторые данные: //////////
//            Person person = session.get(Person.class, 2);
//            person.setName("New name");

//            4/ Удалим из таблицы Person некоторые данные: //////////
//            Person person = session.get(Person.class, 2);
//            session.remove(person);

//            5/ HQL: //////////
//            List<Person> people = session.createQuery("FROM Person where age>30 and name like 'J%'").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }

//            5а/ HQL: //////////
//            session.createQuery("update Person set name='Test' where age>30").executeUpdate();

//            5б/ HQL: //////////
//            session.createQuery("delete from Person where age>30").executeUpdate();

//            6а/ Один ко многим: ////////
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            6б/ Один ко многим: ////////
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//            Person person = item.getOwner();
//            System.out.println(person);

//            6в/ Один ко многим: //////// Добавим новый Item
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person);
//            person.getItems().add(newItem); //строка не обязательная, но лучше ее добаить чтобы в кэше hibernate были актуалые сведения
//            session.persist(newItem);

//            6г/ Один ко многим: //////// Создадим нового человека с новым заказом
//            Person person = new Person("Test person", 30);
//            Item newItem = new Item("Item from Hibernate 2", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem))); //строка не обязательная, но лучше ее добаить чтобы в кэше hibernate были актуалые сведения
//            session.persist(person);
//            session.persist(newItem);

//            6д/ Один ко многим: //////// Удалим все товары у человека с id равным 3

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
//            for (Item item:items)
//                session.remove(item);
//
//            person.getItems().clear(); //это опять для того, чтобы в кэше все было верно

//            6е/ Один ко многим: //////// Удалим человека

//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null)); //это опять для того, чтобы в кэше все было верно

//            6ж/ Один ко многим: //////// Поменяем владельца у существующего товара

//            Person person = session.get(Person.class, 4);
//            Item item = session.get(Item.class, 1);
//
//            item.getOwner().getItems().remove(item);
//
//            item.setOwner(person);
//            person.getItems().add(item);

//            8/ Каскадирование: ////////

//            Person person = new Person("Test cascading", 30);
//
//            person.addItem(new Item("Item1"));
//            person.addItem(new Item("Item2"));
//            person.addItem(new Item("Item3"));
//            session.persist(person);

//            9а/ Один к одному: ////////
//            Person person = new Person("Test person 9", 50);
//            Passport passport = new Passport(12345);
//            person.setPassport(passport);
//            session.persist(person);

//            9б/ Один к одному: ////////
//            Person person = session.get(Person.class, 7);
//            System.out.println(person.getPassport().getPassportNumber());

//            9в/ Один к одному: ////////
//            Passport passport = session.get(Passport.class, 7);
//            System.out.println(passport.getPerson().getName());

//            9г/ Один к одному: //////// Изменим номер пасспорта
//            Person person = session.get(Person.class, 7);
//            person.getPassport().setPassportNumber(77777);

//            9д/ Один к одному: //////// Удалим человека и посмотрим, как удалится и пасспорт
//            Person person = session.get(Person.class, 7);
//            session.remove(person);

//            10а/ Многие ко Многим: ////////
//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.persist(movie);
//            session.persist(actor1);
//            session.persist(actor2);

//            10б/ Многие ко Многим: //////// Получим фильм из БД и выведем список актеров
//            Movie movie = session.get(Movie.class, 1);
//            List<Actor> actors = movie.getActors();
//            System.out.println(actors);

//            10в/ Многие ко Многим: ////////
//            Movie movie = new Movie("Reservoir Gogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.persist(movie);

//            10г/ Многие ко Многим: ////////УДалим из фильма какого нить актера
            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());
            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);


            session.getTransaction().commit();
        }
    }
}