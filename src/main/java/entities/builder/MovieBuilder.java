package entities.builder;

import entities.ActorEntity;
import entities.DirectorEntity;
import entities.MovieEntity;

import java.util.Set;

public class MovieBuilder {
    private String title;
    private Long length;
    private DirectorEntity director;
    private Set<ActorEntity> actors;

    public MovieBuilder() {
    }


    public MovieEntity build() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(this.title);
        movieEntity.setLength(this.length);
        movieEntity.setDirector(this.director);
        movieEntity.setActors(this.actors);
        return movieEntity;
    }

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setLength(Long length) {
        this.length = length;
        return this;
    }

}
