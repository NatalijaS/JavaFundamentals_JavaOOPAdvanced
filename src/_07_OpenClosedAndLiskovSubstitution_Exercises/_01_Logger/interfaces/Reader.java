package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces;

import java.io.IOException;

public interface Reader {

    String readLine() throws IOException;
}
