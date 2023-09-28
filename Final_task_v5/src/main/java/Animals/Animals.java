package Animals;

import Animals.EnumAnimals;

import java.time.LocalDate;
import java.util.ArrayList;


/** Создание основного класса животных **/
public class Animals {
    private int petId;
    private String name;
    private ArrayList commands = new ArrayList<String>();
    private LocalDate birthday;


    @Override
    public String toString() {
        return "Животные {" +
                "Имя - '" + name + '\'' +
                ", Дата рождения - '" + birthday + '\'' +
                '}';
    }


//    public Animals(int petId, String name, ArrayList commands, String birthday) {
//        this.petId = petId;
//        this.name = name;
//        this.commands = commands;
//        this.birthday = birthday;
//    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getCommands() {
        return commands;
    }

    public void setCommands(ArrayList commands) {
        this.commands = commands;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}


