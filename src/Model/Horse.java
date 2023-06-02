package Model;

import java.sql.Date;

public class Horse extends Animal implements Packable {
    public Horse(String name, Date birthday) {
        super(id, name, birthday);
    }
}
