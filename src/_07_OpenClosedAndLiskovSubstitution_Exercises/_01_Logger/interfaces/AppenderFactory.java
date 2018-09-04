package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces;

public interface AppenderFactory {

    Appender createAppender(String[] params) throws ReflectiveOperationException;
}
