package _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions;

public class DuplicateModelException extends Exception {

    public DuplicateModelException(String message) {
        super(message);
    }
}
