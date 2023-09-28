package Exceptions;

/** Класс исключений **/
public class DataException extends RuntimeException{
    
    public DataException(String msg) {
        super(msg);
    }
}