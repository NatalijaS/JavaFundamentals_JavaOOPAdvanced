package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Layout;

public class SimpleLayout implements Layout{

    public SimpleLayout() {}

    @Override
    public String stringFormat(String dateTime, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", dateTime, reportLevel, message);
    }
}
