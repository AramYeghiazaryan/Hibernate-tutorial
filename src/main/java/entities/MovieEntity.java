package entities;

import lombok.Data;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;

@Entity
@Data
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name = "Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String director;

}
