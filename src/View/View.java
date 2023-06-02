package View;

import Controller.AnimalController;
import Model.Animal;
import Services.Counter;
import Services.Validator;

import java.sql.Date;
//import java.time.DateTimeException;
import java.util.List;
import java.util.Scanner;

public class View {

    public AnimalController animalController;


    public View(AnimalController animalController) {

        this.animalController = animalController;
    }

    public void run() throws Exception {
        try (Scanner in = new Scanner(System.in, "ibm866");
             Counter counter = new Counter()) { // кастомный счетчик

            boolean flag = true;
//            int id;
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
                        case "1"://Завести новое животное
                            System.out.println("Выберите вид животного:\n" +
                                    "1 - кот\n" +
                                    "2 - собака\n" +
                                    "3 - хомяк\n" +
                                    "4 - лошадь\n" +
                                    "5 - верблюд\n" +
                                    "6 - осел\n");
                            String animalType = in.next();

                            switch (animalType) {
                                case "1":
                                    animalController.addCat(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();
                                case "2":
                                    animalController.addDog(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();
                                case "3":
                                    animalController.addHamster(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();
                                case "4":
                                    animalController.addHorse(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();

                                case "5":
                                    animalController.addCamel(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();
                                case "6":
                                    animalController.addDonkey(counter.getSum(), inputName(), inputBirthday());
                                    counter.add();
                            }
                            break;
                        case "2": // вывести список всех животных
                            List<Animal> animals = animalController.getAll();
                            for (int i = 0; i < animals.toArray().length; i++) {
                                System.out.println(animals.get(i).toString());
                            }
                            break;

                        case "3": //вывести данные животного по ID
                            System.out.println("Введите id:");
                            int id = Integer.parseInt(in.next());
                            System.out.println(animalController.getAnimal(id).toString());

                        case "4":
//                            while (true) {
//                                id = menuChoicePet(in);
//                                if (id != 0)
//                                    animalController.getCommands(id);
//                                else
//                                    break;
//                            }
                            break;
                        case "5":
//                            id = menuChoicePet(in);
//                            if (id != 0)
//                                menuTrainPet(id, input);
//                            break;
                        case "6":
//                            id = menuChoicePet(in);
//                            if (id != 0)
//                                animalController.delete(id);
//                            break;
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
            System.out.println("Введите имя: ");
            String name = in.next();
            return name;
        }
    }

    public Date inputBirthday() {
        Date birthday =Date.valueOf("2010-01-01") ;
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите дату рождения в формате yyyy-mm-dd");
            String date = in.next();
            Validator validator = new Validator();
            if (validator.isDateValid(date)){
                birthday = Date.valueOf(date);
                return birthday;
            }


        } catch (Exception e) {
            System.out.println("неверная дата" + e.getMessage());
        }
        return birthday;
    }
}
