package entities.builder;

import entities.ActorEntity;
import entities.MovieEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActorBuilder {

    private String name;
    private final Set<MovieEntity> movies = new HashSet<>();


    public ActorEntity build() {
        ActorEntity actor = new ActorEntity();
        actor.setMovies(this.movies);
        actor.setName(this.name);
        return actor;
    }

    public ActorBuilder setActorName(String name) {
        this.name = name;
        return this;
    }

    public ActorBuilder addMovie(MovieEntity... movies) {
        this.movies.addAll(List.of(movies));
        return this;
    }
}
