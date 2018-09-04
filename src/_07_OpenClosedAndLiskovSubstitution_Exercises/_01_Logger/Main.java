package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.core.factories.AppenderFactoryImpl;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.AppenderFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Reader;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Runnable;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Writer;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.core.io.ConsoleReader;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.core.io.ConsoleWriter;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models.Engine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ReflectiveOperationException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        AppenderFactory appenderFactory = new AppenderFactoryImpl();
        Runnable engine = new Engine(reader, writer, appenderFactory);
        engine.run();
    }
}
