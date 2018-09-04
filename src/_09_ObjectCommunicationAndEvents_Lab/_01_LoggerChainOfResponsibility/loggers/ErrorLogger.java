package _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers;

import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.LogType;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.Logger;

public class ErrorLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}
