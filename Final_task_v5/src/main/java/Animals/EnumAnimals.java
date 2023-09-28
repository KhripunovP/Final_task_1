package Animals;

/** Создание класса фиксированного выбора типов животных **/
public enum EnumAnimals {
    CATS, DOGS, HAMSTERS, HORSES, DONKEYS, CAMELS;

    public static EnumAnimals getType (int typeId){
        switch (typeId){
            case 1:
                return EnumAnimals.CATS;
            case 2:
                return EnumAnimals.DOGS;
            case 3:
                return EnumAnimals.HAMSTERS;
            case 4:
                return EnumAnimals.HORSES;
            case 5:
                return EnumAnimals.DONKEYS;
            case 6:
                return EnumAnimals.CAMELS;
            default:
                return null;
        }
    }
}
