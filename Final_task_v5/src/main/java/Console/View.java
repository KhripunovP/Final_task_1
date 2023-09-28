package Console;

import java.util.List;

public interface View <T>{
    
    String getName();
    String getBirthday();
    <U> void printAll (List <U> list, Class <U> classes);
    void showMessage (String s);

}
