package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces;

public interface Controller {

    void log(String[] args) throws ReflectiveOperationException;

    String getLogs();
}
