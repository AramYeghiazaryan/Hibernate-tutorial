package entities.inheritance.table_per_subclass;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "BIRD")
@PrimaryKeyJoinColumn(name = "ANIMAL_ID")
@Data
public class Bird extends Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer flySpeed;


}
