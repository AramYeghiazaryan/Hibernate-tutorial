import entities.ActorEntity;
import entities.DirectorEntity;
import entities.MovieEntity;
import entities.builder.ActorBuilder;
import entities.builder.DirectorBuilder;
import entities.builder.MovieBuilder;
import utils.EntityPersist;

import java.util.List;
import java.util.Set;

public class HibernateTest {
    private static final EntityPersist<MovieEntity> moviePersist = new EntityPersist<>();
    private static final EntityPersist<ActorEntity> actorPersist = new EntityPersist<>();
    private static final EntityPersist<DirectorEntity> directorPersist = new EntityPersist<>();

    public static void main(String[] args) {

        DirectorEntity directorJohn = constructDirector("John");
        DirectorEntity directorBob = constructDirector("Bob");
        DirectorEntity directorSteve = constructDirector("Steve");

        directorPersist.persist(List.of(directorBob, directorJohn, directorSteve));

        ActorEntity actorAndo = constructActor("Ando");
        ActorEntity actorVzgo = constructActor("Vzgo");
        ActorEntity actorValod = constructActor("Valod");

        actorPersist.persist(List.of(actorAndo, actorValod, actorVzgo));

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

        moviePersist.persist(List.of(movie1, movie2, movie3, movie4, movie5));
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
