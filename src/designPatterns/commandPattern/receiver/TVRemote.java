package designPatterns.commandPattern.receiver;

public class TVRemote {

    public static ElectronicDevice getDevice() {

        return new Television();
    }
}
