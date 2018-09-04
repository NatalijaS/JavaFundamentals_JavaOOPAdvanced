package _09_ObjectCommunicationAndEvents_Lab._02_Command.commands;

import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab._03_Mediator.AttackGroup;

public class GroupAttackCommand implements Command{

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupAttack();
    }
}
