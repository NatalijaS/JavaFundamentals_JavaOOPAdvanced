package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface;

public interface Formatter {

    <T> String format(Iterable<T> items);
}
