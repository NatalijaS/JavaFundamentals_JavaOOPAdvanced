package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.commands;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.RoyalGroup;

public class AttackCommand implements Command {

    RoyalGroup royalGroup;

    public AttackCommand(RoyalGroup royalGroup) {
        this.royalGroup = royalGroup;
    }

    @Override
    public void execute() {
        this.royalGroup.attackGroup();
    }
}
