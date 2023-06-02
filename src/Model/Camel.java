package Model;

import Model.Animal;

import java.sql.Date;

public class Camel extends Animal implements Packable {
    public Camel(int id, String name, Date birthday) {
        super(id, name, birthday);
    }
}
