package Model;

import Model.Animal;

import java.sql.Date;

public class Dog extends Animal implements Petable {
    public Dog(String name, Date birthday) {
        super(name, birthday);
    }
}
