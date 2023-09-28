package Controller;

import Animals.*;

/** Наследование от абстрактного класса **/
public class PetCreator extends Creator {

    @Override
    protected Animals createNewPet (EnumAnimals type) {

        switch (type) {
            case CATS:
                return new Cats();
            case DOGS:
                return new Dogs();
            case HAMSTERS:
                return new Hamsters();
            case HORSES:
                return new Horses();
            case CAMELS:
                return new Camels();
            case DONKEYS:
                return new Donkeys();
        }
        return null;
    }
}
