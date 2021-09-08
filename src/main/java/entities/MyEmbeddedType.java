package entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class MyEmbeddedType {

    String AAAAA;
    String BBBBB;
}
