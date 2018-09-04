package exams._2017_04_18_Emergency;

import exams._2017_04_18_Emergency.core.EmergencyManagementSystem;
import exams._2017_04_18_Emergency.core.ManagementSystem;
import exams._2017_04_18_Emergency.engines.Engine;
import exams._2017_04_18_Emergency.interpreters.CommandInterpreter;
import exams._2017_04_18_Emergency.interpreters.Interpreter;
import exams._2017_04_18_Emergency.io.ConsoleReader;
import exams._2017_04_18_Emergency.io.ConsoleWriter;
import exams._2017_04_18_Emergency.io.Reader;
import exams._2017_04_18_Emergency.io.Writer;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);
        Runnable engine = new Engine(reader,writer,interpreter);
        engine.run();
    }
}
