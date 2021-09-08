package entities.inheritance.table_per_concrete_class;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private Integer hp;

    private Integer speed;

    private String maker;
}
