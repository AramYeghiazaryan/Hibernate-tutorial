package entities.builder;

import entities.DirectorEntity;
import entities.MovieEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectorBuilder {
    private String name;
    private final Set<MovieEntity> movies = new HashSet<>();

    public DirectorEntity build() {

        DirectorEntity director = new DirectorEntity();
        director.setName(this.name);
        director.setMovies(this.movies);

        return director;
    }

    public DirectorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DirectorBuilder addMovie(MovieEntity... movies) {
        this.movies.addAll(List.of(movies));
        return this;
    }

}
