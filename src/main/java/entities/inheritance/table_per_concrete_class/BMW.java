package entities.inheritance.table_per_concrete_class;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BMW")
@Data
public class BMW extends Car {

    public BMW() {
        setMaker("BMW");
    }

    private boolean isXdrive;

    @Override
    public void setMaker(String maker) {
        super.setMaker(maker);
    }
}
