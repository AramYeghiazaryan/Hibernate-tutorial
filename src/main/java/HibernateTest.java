import entities.MovieEntity;
import entities.builder.MovieBuilder;
import utils.EntityPersist;

public class HibernateTest {
    public static void main(String[] args) {
        EntityPersist<MovieEntity> moviePersist = new EntityPersist<>();
        moviePersist.persist(constructMovie());
    }

    public static MovieEntity constructMovie() {
        return new MovieBuilder()
                .setDirector("Director")
                .setTitle("TITLE")
                .build();
    }
}
