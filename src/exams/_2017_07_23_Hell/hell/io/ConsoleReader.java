package exams._2017_07_23_Hell.hell.io;

import exams._2017_07_23_Hell.hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {

    BufferedReader reader;

    public ConsoleReader() {
        this.reader =new BufferedReader(new InputStreamReader(System.in));;
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}
