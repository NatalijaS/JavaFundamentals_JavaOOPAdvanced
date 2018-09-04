package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.core.io;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
