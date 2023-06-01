package View;

import Controller.AnimalController;
import Model.*;
import Services.Counter;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.util.Scanner;

public class View {

    private AnimalController animalController;


    public View(AnimalController animalController) {

        this.animalController = animalController;
    }

    public void run() throws Exception {
        try (Scanner in = new Scanner(System.in, "ibm866");
             Counter count = new Counter()) { // кастомный счетчик

            boolean flag = true;
            int id;
            while (flag) {
                System.out.println("Список команд:\n" +
                        "1 - Завести новое животное \n" +
                        "2 - вывести список всех животных \n" +
                        "3 - вывести данные животного по ID \n" +
                        "4 - увидеть список команд, которое выполняет животное(ID)\n" +
                        "5 - обучить животное новым командам \n" +
                        "6 - удалить животное \n" +
                        "7 - выход \n");

                String command = in.next();
                try {
                    switch (command) {
                        case "1":
                            String animalType = in.next();
                            System.out.println("Выберите вид животного:\n" +
                                    "1 - кот\n" +
                                    "2 - собака\n" +
                                    "3 - хомяк\n" +
                                    "4 - лошадь\n" +
                                    "5 - верблюд\n" +
                                    "6 - осел\n");

                            switch (animalType) {
                                case "1":
                                     animalController.addCat(inputName(), inputBirthday());
                            }


                            PetType type = menuChoice(in);
                            if (type != null) {
                                try {
                                    animalController.createPet(type);
                                    count.add();
                                    System.out.println("ОК");
                                } catch (UncorrectDataException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case "2":
                            animalController.getAllPet();
                            break;

                        case "3":
                            while (true) {
                                id = menuChoicePet(in);
                                if (id != 0)
                                    try {
                                        animalController.updatePet(id);
                                    } catch (UncorrectDataException e) {
                                        System.out.println(e.getMessage());
                                    }
                                else
                                    break;
                            }
                            break;
                        case "4":
                            while (true) {
                                id = menuChoicePet(in);
                                if (id != 0)
                                    animalController.getCommands(id);
                                else
                                    break;
                            }
                            break;
                        case "5":
                            id = menuChoicePet(in);
                            if (id != 0)
                                menuTrainPet(id, input);
                            break;
                        case "6":
                            id = menuChoicePet(in);
                            if (id != 0)
                                animalController.delete(id);
                            break;
                        case "7":
                            System.out.println("До свидания");
                            flag = false;
                            break;
                        default:
                            System.out.println("такого варианта нет");
                            break;
                    }

                } catch (Exception e) {
                    System.out.println("что-то пошло не так...\n" + e.getMessage());
                }
            }
        }
    }

//    public Animal createAnimal(String name, Date birthday, String type) {
//
//        switch (type) {
//            case "cat":
//                return new Cat(name, birthday);
//            case "dog":
//                return new Dog(name, birthday);
//            case "hamster":
//                return new Hamster(name, birthday);
//            case "horse":
//                return new Horse(name, birthday);
//            case "donkey":
//                return new Donkey(name, birthday);
//            case "camel":
//                return new Camel(name, birthday);
//            default:
//                return null;
//        }
//    }

    public String inputName() {
        try (Scanner in = new Scanner(System.in, "ibm866")) {
            String name = in.next("Введите имя: ");
            return name;
        }
    }

    public Date inputBirthday() {
        Date birthday = null;
        try (Scanner in = new Scanner(System.in, "ibm866")) {
            birthday = Date.valueOf(in.next("Введите дату рождения в формате yyyy-mm-dd"));

        } catch (DateTimeException e) {
            System.out.println("неверная дата" + e.getMessage());
        }
        return birthday;
    }
}
