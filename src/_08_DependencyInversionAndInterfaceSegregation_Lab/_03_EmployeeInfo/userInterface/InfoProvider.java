package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface;

import java.util.Comparator;

public interface InfoProvider<T> {

    Iterable<T> getBy(Comparator<T> comparator);
}
