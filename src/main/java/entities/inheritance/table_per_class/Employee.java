package entities.inheritance.table_per_class;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employee")
@Data
public class Employee extends Person {

    @Column
    private String role;

}
