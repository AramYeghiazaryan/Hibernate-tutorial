package entities.inheritance.table_per_class;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR")
@DiscriminatorValue("Person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;
}
