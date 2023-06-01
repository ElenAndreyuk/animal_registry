package Model;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Animal {
    protected static int id;
    public String name;
    public Date birthday;
    public ArrayList <String> commands;


    public Animal(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public String getCommands() {
        return commands.toString();
    }

    public void addCommand(String command){
        commands.add(command);

    }
    @Override
    public String toString() {
        return String.format("ID: %d имя: %s, дата рождения: %s ",  name, getBirthday());
    }

}
