package _09_ObjectCommunicationAndEvents_Lab._02_Command.commands;

import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab.models.Attacker;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
