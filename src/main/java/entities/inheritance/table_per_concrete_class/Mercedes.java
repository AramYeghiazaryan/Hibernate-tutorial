package entities.inheritance.table_per_concrete_class;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MERCEDES")
@Data
public class Mercedes extends Car {


    public Mercedes() {
        setMaker("Mercedes");
    }

    private boolean is4Matic;

    @Override
    public void setMaker(String maker) {
        super.setMaker(maker);
    }
}
