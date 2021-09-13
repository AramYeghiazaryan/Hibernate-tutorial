import entities.ActorEntity;
import entities.DirectorEntity;
import entities.MovieEntity;
import entities.builder.ActorBuilder;
import entities.builder.DirectorBuilder;
import entities.builder.MovieBuilder;
import entities.inheritance.table_per_class.Employee;
import entities.inheritance.table_per_class.Person;
import entities.inheritance.table_per_concrete_class.BMW;
import entities.inheritance.table_per_concrete_class.Car;
import entities.inheritance.table_per_concrete_class.Mercedes;
import entities.inheritance.table_per_subclass.Animal;
import entities.inheritance.table_per_subclass.Bird;
import org.hibernate.Session;
import utils.EntityPersist;
import utils.HQLUtils;
import utils.SessionFactorySingleton;
import utils.TransactionUtils;

import java.util.List;
import java.util.Set;

public class HibernateTest {
    private static final EntityPersist<MovieEntity> moviePersist = new EntityPersist<>();
    private static final EntityPersist<ActorEntity> actorPersist = new EntityPersist<>();
    private static final EntityPersist<DirectorEntity> directorPersist = new EntityPersist<>();
    private static final EntityPersist<Person> personPersist = new EntityPersist<>();
    private static final EntityPersist<Animal> animalEntityPersist = new EntityPersist<>();
    private static final EntityPersist<Car> carEntityPersist = new EntityPersist<>();

    public static void main(String[] args) {

        testMovie();
        testInheritanceTablePerClass();
        testInheritanceTablePerSubClass();
        testInheritanceTablePerConcreteClass();
    }

    private static void testHQL() {
        Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        List<MovieEntity> movieEntities = HQLUtils.getList(MovieEntity.class, session);
        System.out.println(movieEntities);
    }

    private static void testInheritanceTablePerConcreteClass() {
        Car car = new Car();
        car.setHp(120);
        car.setMaker("Mitsubishi");
        car.setSpeed(180);

        BMW bmw = new BMW();
        bmw.setXdrive(true);
        bmw.setHp(302);
        bmw.setSpeed(280);

        Mercedes mercedes = new Mercedes();
        mercedes.set4Matic(true);
        mercedes.setHp(280);
        mercedes.setSpeed(240);

        carEntityPersist.persist(bmw, mercedes);
    }

    private static void testInheritanceTablePerSubClass() {
        Animal animal = new Animal();
        animal.setSound("Hav hav");
        animal.setType("Dog");

        Bird bird = new Bird();
        bird.setType("sparrow");
        bird.setFlySpeed(10);
        bird.setSound("Civ civ");

        animalEntityPersist.persist(animal);
        animalEntityPersist.persist(bird);

        System.out.println(animalEntityPersist.getById(Animal.class, 2L));

    }

    private static void testInheritanceTablePerClass() {
        Person person = new Person();
        person.setAge(12);
        person.setName("AAAA");

        Employee employee = new Employee();
        employee.setAge(24);
        employee.setName("BBBBB");
        employee.setRole("SOME ROLE");
        personPersist.persist(employee, person);

        System.out.println(personPersist.getById(Person.class, 1L));
        System.out.println(personPersist.getById(Person.class, 2L));
    }

    private static void testMovie() {
        DirectorEntity directorJohn = constructDirector("John");
        DirectorEntity directorBob = constructDirector("Bob");
        DirectorEntity directorSteve = constructDirector("Steve");

        directorPersist.persist(directorBob, directorJohn, directorSteve);

        ActorEntity actorAndo = constructActor("Ando");
        ActorEntity actorVzgo = constructActor("Vzgo");
        ActorEntity actorValod = constructActor("Valod");

        actorPersist.persist(actorAndo, actorValod, actorVzgo);

        MovieEntity movie1 = constructMovie("Title", 120L);
        MovieEntity movie2 = constructMovie("Title 2", 130L);
        MovieEntity movie3 = constructMovie("Title 3", 140L);
        MovieEntity movie4 = constructMovie("Title 4", 150L);
        MovieEntity movie5 = constructMovie("Title 5", 160L);

        movie1.setDirector(directorJohn);
        movie2.setDirector(directorJohn);
        movie3.setDirector(directorBob);
        movie4.setDirector(directorBob);
        movie5.setDirector(directorSteve);

        movie1.setActors(Set.of(actorAndo, actorVzgo));
        movie2.setActors(Set.of(actorVzgo));
        movie3.setActors(Set.of(actorAndo, actorValod));
        movie4.setActors(Set.of(actorAndo));
        movie5.setActors(Set.of(actorValod, actorVzgo));

        moviePersist.persist(movie1, movie2, movie3, movie4, movie5);
    }

    public static MovieEntity constructMovie(String title, Long length) {
        return new MovieBuilder()
                .setTitle(title)
                .setLength(length)
                .build();
    }

    public static DirectorEntity constructDirector(String name) {
        return new DirectorBuilder()
                .setName(name)
                .build();
    }

    public static ActorEntity constructActor(String name) {
        return new ActorBuilder()
                .setActorName(name)
                .build();
    }
}
