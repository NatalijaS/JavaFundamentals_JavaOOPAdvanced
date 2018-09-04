package _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility;

public interface Handler {

    void handle(LogType logType, String message);

    void setSuccessor(Handler successor);
}
