package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Layout;

public class ConsoleAppender extends AbstractAppender{

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, String message) {
        ReportLevel reportLevel = this.getMessageReportLevel();
        if (super.reportLevelIsAboveOrEqual(reportLevel)) {
            System.out.println(this.getLayout().stringFormat(dateAndTime, message, reportLevel));
            this.setMessagesAppended(this.getMessagesAppended() + 1);
        }
    }
}
