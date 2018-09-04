package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.models.Employee;

import java.util.Comparator;

public class ConsoleClient {

    private InfoProvider<Employee> infoProvider;
    private Writer writer;
    private Formatter formatter;

    public ConsoleClient(InfoProvider<Employee> infoProvider, Writer writer, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.writer = writer;
        this.formatter = formatter;
    }

    public void run() {
        Iterable<Employee> employeesByName = this.infoProvider.getBy(Comparator.comparing(Employee::getName));
        String output = this.formatter.format(employeesByName);
        this.writer.println(output);
    }
}
