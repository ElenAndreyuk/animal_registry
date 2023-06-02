package Controller;

import Model.*;
import Services.AnimalRepository;
import Services.Validator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    private AnimalRepository animalRepository;


    public AnimalController(AnimalRepository animalRepository) {

        this.animalRepository = animalRepository;
    }

    //    List<Animal> animals = animalRepository.getAll();
    List<Animal> animals = new ArrayList<Animal>();

    public void start() {
        ;
    }

    public void addCat(int id, String name, Date birthday) {
        Cat cat = new Cat(id, name, birthday);
        animals.add(cat);
    }

    public void addDog(int id, String name, Date birthday) {
        Dog dog = new Dog(name, birthday);
        animals.add(dog);
    }

    public void addHamster(int id, String name, Date birthday) {
        Hamster hamster = new Hamster(name, birthday);
        animals.add(hamster);
    }

    public void addHorse(int id, String name, Date birthday) {
        Horse horse = new Horse(name, birthday);
        animals.add(horse);
    }

    public void addDonkey(int id, String name, Date birthday) {
        Donkey donkey = new Donkey(name, birthday);
        animals.add(donkey);
    }

    public void addCamel(int id, String name, Date birthday) {
        Camel camel = new Camel(id, name, birthday);
        animals.add(camel);
    }

    public List<Animal> getAll() {
        return animalRepository.getAll();
    }

    public Animal getAnimal(int id) {
        return animals.get(id);
    }


}
