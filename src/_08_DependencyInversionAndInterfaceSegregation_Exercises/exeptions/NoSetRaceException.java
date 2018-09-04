package _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions;

public class NoSetRaceException extends Exception{

    public NoSetRaceException(String message) {
        super(message);
    }
}
