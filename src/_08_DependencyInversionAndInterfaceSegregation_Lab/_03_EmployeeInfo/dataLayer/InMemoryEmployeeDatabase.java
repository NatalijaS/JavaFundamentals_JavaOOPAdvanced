package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.dataLayer;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.models.Employee;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.buisnessLayer.EmployeeDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryEmployeeDatabase implements EmployeeDatabase {

    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40),
                new Employee("Angel", 15));

        return employees;
    }
}
