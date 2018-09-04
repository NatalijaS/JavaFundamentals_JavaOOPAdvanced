package designPatterns.commandPattern.commands;

import designPatterns.commandPattern.receiver.ElectronicDevice;

public class TurnTVUp implements Command {

    private ElectronicDevice theDevice;

    public TurnTVUp(ElectronicDevice newDevice) {

        theDevice = newDevice;
    }

    public void execute() {

        theDevice.volumeUp();
    }

    public void undo() {

        theDevice.volumeDown();
    }
}
