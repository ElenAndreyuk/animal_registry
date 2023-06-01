package Controller;

import Model.Animal;
import Model.Cat;
import Services.IRepository;

import java.sql.Date;
import java.util.List;

public class AnimalController {
    private IRepository<Animal> animalRepository;

    public AnimalController(IRepository animalRepository) {

        this.animalRepository = animalRepository;
    }
    List<Animal> animals = animalRepository.getAll();
    public addCat(String name, Date birthday){
        Cat cat = new Cat(name, birthday);
        animals.add(cat);
    }
    public addDog(String name, Date birthday){
        Dog dog = new Dog(name, birthday);
        animals.add(cat);
    }



}
