package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    public XmlLayout() {}

    @Override
    public String stringFormat(String dateTime, String message, ReportLevel reportLevel) {
        return "<log>\n" +
                "\t<date>" + dateTime + "</date>\n" +
                "\t<level>" + reportLevel + "</level>\n" +
                "\t<message>" + message+  "</message>\n" +
                "</log>";
    }
}
