package _09_ObjectCommunicationAndEvents_Lab._02_Command.commands;

import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;
import _09_ObjectCommunicationAndEvents_Lab.models.Attacker;

public class TargetCommand implements Command {

    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.setTarget(target);
    }
}
