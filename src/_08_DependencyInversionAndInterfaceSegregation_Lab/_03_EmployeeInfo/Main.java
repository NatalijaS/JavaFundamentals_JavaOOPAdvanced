package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.buisnessLayer.EmployeeDatabase;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.buisnessLayer.EmployeeInfoProvider;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.dataLayer.InMemoryEmployeeDatabase;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.io.PrintWriter;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface.ConsoleClient;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        EmployeeDatabase db = new InMemoryEmployeeDatabase();
        EmployeeInfoProvider employeeInfo = new EmployeeInfoProvider(db);
        PrintWriter writer = new PrintWriter(new PrintStream(System.out));

        ConsoleClient client = new ConsoleClient(employeeInfo, writer, writer);
        client.run();
    }
}
