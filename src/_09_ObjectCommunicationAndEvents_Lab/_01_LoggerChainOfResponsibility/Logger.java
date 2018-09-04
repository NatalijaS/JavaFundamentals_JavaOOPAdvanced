package _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility;

public abstract class Logger implements Handler {

    private Handler successor;

    @Override
    public abstract void handle(LogType logType, String message);

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType logType, String message) {
        if (this.successor != null) {
            this.successor.handle(logType, message);
        }
    }
}
