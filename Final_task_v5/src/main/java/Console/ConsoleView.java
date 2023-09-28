package Console;

import Animals.Animals;

import java.util.List;
import java.util.Scanner;

/** Класс методов консоли, использование интерфейса абстрактных методов View **/
public class ConsoleView implements View <Animals> {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getName() {
        System.out.print("Имя: ");
        return in.nextLine();
    }

    @Override
    public String getBirthday() {
        System.out.print("Введите дату рождения в формате 'dd.MM.yyyy': ");
        return in.nextLine();
    }

    @Override
    public <T> void printAll (List <T> list, Class <T> classes) {
        if (list.isEmpty())
            System.out.println("список пуст");
        else {
            if (classes == Animals.class)
                System.out.println("\n Наши питомцы:");
            for (T item : list) {
                System.out.println(item);              
            }
        }
    }
    
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
