package Console;

import java.util.Scanner;
import Controller.*;
import Exceptions.DataException;
import Animals.EnumAnimals;

/** Создание меню действи для пользователя **/
public class ConsoleMenu {

    PetController petController;

    public ConsoleMenu(PetController controller) {
        this.petController = controller;
    }

    public void start() {

//        System.out.print("\033[H\033[J");
        try (Scanner in = new Scanner(System.in); Counter count = new Counter()) {

            boolean flag = true;
            int id;
            while (flag) {

                System.out.println("Что Вы хотите сделать?" + "\n" +
                        "1 - Список всех животных" + "\n" +
                        "2 - Завести новое животное" + "\n" +
                        "3 - Изменить данные о животном" + "\n" +
                        "4 - Что умеет животное" + "\n" +
                        "5 - Дрессировка" + "\n" +
                        "6 - Удалить запись" + "\n" +
                        "0 - Выход");
                String key = in.next();

                switch (key) {
                    case "1":
                        petController.getAllPet();
                        break;
                    case "2":
                        EnumAnimals type = menuChoice(in);
                        if (type != null) {
                            try {
                                petController.createPet(type);
                                count.add();
                                System.out.println("ОК");
                            } catch (DataException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            id = menuChoicePet(in);
                            if (id != 0)
                                try {
                                    petController.updatePet(id);
                                } catch (DataException e) {
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
                                petController.getCommands(id);
                            else
                                break;
                        }
                        break;
                    case "5":
                        id = menuChoicePet(in);
                        if (id != 0)
                            menuTrainPet(id, in);
                        break;
                    case "6":
                        id = menuChoicePet(in);
                        if (id != 0)
                            petController.delete(id);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("такого варианта нет");
                        break;
                }
            }
        }
    }

    private EnumAnimals menuChoice(Scanner in) {
        System.out.println("Какое животное добавить:" + "\n" +
                "1 - Кошка" + "\n" +
                "2 - Собака" + "\n" +
                "3 - Хомяк" + "\n" +
                "4 - Собака" + "\n" +
                "5 - Осел" + "\n" +
                "6 - Верблюд" + "\n" +
                "0 - Возврат в основное меню");

        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    return EnumAnimals.CATS;
                case "2":
                    return EnumAnimals.DOGS;
                case "3":
                    return EnumAnimals.HAMSTERS;
                case "4":
                    return EnumAnimals.HORSES;
                case "5":
                    return EnumAnimals.DONKEYS;
                case "6":
                    return EnumAnimals.CAMELS;
                case "0":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число от 0 до 6");
                    break;
            }
        }
    }

    private int menuChoicePet(Scanner in) {
        System.out.println("\nВведите номер животного, 0 для возврата в основное меню: ");
        while (true) {
            int id = in.nextInt();
            in.nextLine();
            if (id == 0)
                return id;
            if (petController.getById(id) == null) {
                System.out.println("Животного с таким номером нет, попробуйте еще раз, 0 для возврата в основное меню:");
            } else
                return id;
        }
    }

    private void menuTrainPet(int petId, Scanner in) {
        Scanner sc = in;
        while (true) {
            System.out.println("Введите новую команду, 0 для возврата в основное меню: ");
            String command = sc.nextLine();
            if (command.length() == 1 && command.equals("0"))
                return;
            if (petController.trainPet(petId, command))
                System.out.println("получилось!");
        }
    }
}