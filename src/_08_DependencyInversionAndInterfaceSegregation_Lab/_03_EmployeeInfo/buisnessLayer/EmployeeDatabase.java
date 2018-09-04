package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.buisnessLayer;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.models.Employee;

import java.util.List;

public interface EmployeeDatabase {

    List<Employee> readEmployees();
}
