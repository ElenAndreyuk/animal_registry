package Model;

import Model.Animal;

import java.sql.Date;

public class Donkey extends Animal implements Packable {
    public Donkey(String name, Date birthday) {
        super(name, birthday);
    }
}
