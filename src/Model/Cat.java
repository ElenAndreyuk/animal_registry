package Model;

import Model.Animal;

import java.sql.Date;

public class Cat extends Animal implements Petable {
    public Cat(int id, String name, Date birthday) {
        super(id, name, birthday);
    }
}
