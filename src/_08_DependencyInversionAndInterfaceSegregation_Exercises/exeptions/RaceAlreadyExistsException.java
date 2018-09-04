package _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions;

public class RaceAlreadyExistsException extends Exception {

    public RaceAlreadyExistsException(String message) {
        super(message);
    }
}
