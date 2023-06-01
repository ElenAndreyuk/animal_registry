package Model;

import Model.Animal;

import java.sql.Date;

public class Cat extends Animal implements Petable {
    public Cat(String name, Date birthday) {
        super(name, birthday);
    }
}
