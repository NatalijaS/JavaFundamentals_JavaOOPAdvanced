package _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.io;

import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface.Formatter;
import _08_DependencyInversionAndInterfaceSegregation_Lab._03_EmployeeInfo.userInterface.Writer;

import java.io.PrintStream;

public class PrintWriter implements Writer, Formatter {

    private PrintStream output;

    public PrintWriter(PrintStream output) {
        this.output = output;
    }

    public void println(String message) {
        this.output.println(message);
    }

    public <T> String format(Iterable<T> items) {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
