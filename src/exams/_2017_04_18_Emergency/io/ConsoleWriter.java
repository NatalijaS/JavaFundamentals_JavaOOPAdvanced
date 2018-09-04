package exams._2017_04_18_Emergency.io;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
