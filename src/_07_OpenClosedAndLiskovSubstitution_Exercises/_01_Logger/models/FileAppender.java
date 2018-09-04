package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.File;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Layout;

public class FileAppender extends AbstractAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, String message) {
        ReportLevel reportLevel = super.getMessageReportLevel();
        if (super.reportLevelIsAboveOrEqual(reportLevel)) {
            String output = this.getLayout().stringFormat(dateAndTime, message, reportLevel);
            this.file.write(output);
            this.setMessagesAppended(this.getMessagesAppended() + 1);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
