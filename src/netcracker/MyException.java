package netcracker;

public class MyException extends Exception{
    private int number;
    public int getNumber(){return number;}
    public MyException(String message){
        super(message);
    }
}
