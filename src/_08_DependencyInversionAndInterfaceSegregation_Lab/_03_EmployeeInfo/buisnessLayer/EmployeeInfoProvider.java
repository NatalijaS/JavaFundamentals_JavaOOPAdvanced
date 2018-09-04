package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.buisnessLayer;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.models.Employee;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface.InfoProvider;

import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider<Employee> {

    private EmployeeDatabase database;

    public EmployeeInfoProvider(EmployeeDatabase database) {
        this.database = database;
    }

    public Iterable<Employee> getBy(Comparator<Employee> comparator) {
        return this.database.readEmployees().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
