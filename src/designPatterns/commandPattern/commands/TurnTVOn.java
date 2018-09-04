package designPatterns.commandPattern.commands;

import designPatterns.commandPattern.receiver.ElectronicDevice;

public class TurnTVOn implements Command {

    private ElectronicDevice theDevice;

    public TurnTVOn(ElectronicDevice newDevice) {

        theDevice = newDevice;
    }

    public void execute() {

        theDevice.on();
    }

    public void undo() {

        theDevice.off();
    }
}
