package Services;

import java.util.List;

/** Абстрактный интерфейс методов для работы с Базой Данных **/
public interface IRegistry<T> {
  
        List <T> getAll();
        T getById(int id);
        int create(T item);
        int update(T item);  
        void delete (int item);  
}
