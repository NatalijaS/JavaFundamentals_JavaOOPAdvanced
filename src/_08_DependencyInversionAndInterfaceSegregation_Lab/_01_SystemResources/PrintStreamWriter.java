package _08_DependencyInversionAndInterfaceSegregation_Lab._01_SystemResources;

import java.io.PrintStream;

public class PrintStreamWriter implements Writer {

    private PrintStream printStream;

    public PrintStreamWriter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void println(String message) {
        this.printStream.println(message);
    }
}
