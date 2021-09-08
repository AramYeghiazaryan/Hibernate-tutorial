package entities.inheritance.table_per_subclass;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private Long id;

    private String type;

    private String sound;

}
