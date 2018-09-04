package designPatterns.commandPattern.commands;

import designPatterns.commandPattern.receiver.ElectronicDevice;

import java.util.List;

public class TurnItAllOff implements Command {

    private List<ElectronicDevice> theDevices;

    public TurnItAllOff(List<ElectronicDevice> newDevices) {
        theDevices = newDevices;
    }

    public void execute() {

        for (ElectronicDevice device : theDevices) {
            device.off();
        }
    }

    public void undo() {

        for (ElectronicDevice device : theDevices) {
            device.on();
        }
    }
}
