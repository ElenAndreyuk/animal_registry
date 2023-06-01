package Model;

import Model.Animal;

import java.sql.Date;

public class Camel extends Animal implements Packable {
    public Camel(String name, Date birthday) {
        super(name, birthday);
    }
}
