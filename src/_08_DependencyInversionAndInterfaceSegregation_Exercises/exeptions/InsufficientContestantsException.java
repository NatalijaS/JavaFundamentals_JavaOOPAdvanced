package _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions;

public class InsufficientContestantsException extends Exception{

    public InsufficientContestantsException(String message) {
        super(message);
    }
}
