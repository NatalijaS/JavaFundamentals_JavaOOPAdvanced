package exams._2018_08_12_CallOfDuty.callofduty.io;

import exams._2018_08_12_CallOfDuty.callofduty.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
