package Model;

import Model.Animal;

import java.sql.Date;

public class Hamster extends Animal implements Petable {
    public Hamster(String name, Date birthday) {
        super(name, birthday);
    }
}
