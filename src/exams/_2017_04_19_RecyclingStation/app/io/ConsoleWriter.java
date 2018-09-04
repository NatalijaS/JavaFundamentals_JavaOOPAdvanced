package exams._2017_04_19_RecyclingStation.app.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
