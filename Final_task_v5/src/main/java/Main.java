import Animals.Animals;
import Console.ConsoleMenu;
import Controller.PetController;
import Services.IRegistry;
import Services.PetRegistry;

/** Запуск программы **/

public class Main {
    public static void main(String[] args) throws Exception {

        IRegistry<Animals> myFarm = new PetRegistry();
        PetController controller = new PetController(myFarm);
        new ConsoleMenu (controller).start();
    }
}    