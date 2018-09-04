package _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions;

public class NonExistantModelException extends Exception {

    public NonExistantModelException(String message) {
        super(message);
    }
}
