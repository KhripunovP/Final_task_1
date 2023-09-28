package Controller;

import Animals.*;

import java.time.LocalDate;

/** Создание абстрактного класса Creator **/
public abstract class Creator {

    protected abstract Animals createNewPet(EnumAnimals type);

    public Animals createPet(EnumAnimals type, String name, LocalDate date) {

        Animals pet = createNewPet(type);
        pet.setName(name);
        pet.setBirthday(date);
        return pet;
    }
}
