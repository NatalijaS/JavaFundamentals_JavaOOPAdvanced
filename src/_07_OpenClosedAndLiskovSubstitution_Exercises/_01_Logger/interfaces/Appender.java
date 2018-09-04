package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;

public interface Appender {

    void append(String dateAndTime,String message);

    void setReportLevel(ReportLevel reportLevel);

    Layout getLayout();
}
