package entities.builder;

import entities.MovieEntity;

public class MovieBuilder {
    private String title;
    private String director;

    public MovieBuilder() {}


    public MovieEntity build() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setDirector(this.director);
        movieEntity.setTitle(this.title);
        return movieEntity;
    }

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setDirector(String director) {
        this.director = director;
        return this;
    }


}
