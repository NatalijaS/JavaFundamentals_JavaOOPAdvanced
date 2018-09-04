package exams._2017_07_23_Hell.hell.io;

import exams._2017_07_23_Hell.hell.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
