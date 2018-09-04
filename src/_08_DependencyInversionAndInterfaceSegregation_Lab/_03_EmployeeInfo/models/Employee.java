package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.models;

public class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getSalary();
    }
}
