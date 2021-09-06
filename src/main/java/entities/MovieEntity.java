package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int id;

    @Column
    private String title;

    @Column
    private Long length;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DIRECTOR_ID")
    private DirectorEntity director;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIE_ACTORS",
            joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACTOR_ID")})
    private Set<ActorEntity> actors;

}
