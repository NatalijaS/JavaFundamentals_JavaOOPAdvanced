package _09_ObjectCommunicationAndEvents_Lab._02_Command.commands;

import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab._03_Mediator.AttackGroup;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;

public class GroupTargetCommand implements Command{

    private ObservableTarget target;
    private AttackGroup group;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.target = target;
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupTarget(target);
    }
}
