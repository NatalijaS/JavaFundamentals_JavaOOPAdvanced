package designPatterns.commandPattern.commands;

import designPatterns.commandPattern.receiver.ElectronicDevice;

public class TurnTVOff implements Command {

    private ElectronicDevice theDevice;

    public TurnTVOff(ElectronicDevice newDevice) {

        theDevice = newDevice;
    }

    public void execute() {

        theDevice.off();
    }

    // Used if you want to allow for undo
    // Do the opposite of execute()
    public void undo() {

        theDevice.on();
    }
}
