package _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers;

import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.LogType;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.Logger;

public class EventLogger extends Logger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT) {
            System.out.println(logType + ": " + message);
        }

        super.passToSuccessor(logType, message);
    }
}
