package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Actor")
@Data
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ID")
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIE_ACTORS",
            joinColumns = {@JoinColumn(name = "ACTOR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MOVIE_ID")})
    private Set<MovieEntity> movies;
}
