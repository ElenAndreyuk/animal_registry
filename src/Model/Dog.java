package Model;

import java.sql.Date;

public class Dog extends Animal implements Petable {
    public Dog(String name, Date birthday) {
        super(id, name, birthday);
    }
}
