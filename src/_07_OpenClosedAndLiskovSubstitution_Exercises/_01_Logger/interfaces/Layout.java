package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;

public interface Layout {

    String stringFormat(String dateTime , String message, ReportLevel reportLevel);
}
