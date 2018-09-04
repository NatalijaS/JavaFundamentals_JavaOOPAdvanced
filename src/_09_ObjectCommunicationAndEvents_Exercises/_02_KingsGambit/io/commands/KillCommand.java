package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.commands;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.RoyalGroup;

public class KillCommand implements Command {

    RoyalGroup royalGroup;
    String targetName;

    public KillCommand(RoyalGroup royalGroup, String targetName) {
        this.royalGroup = royalGroup;
        this.targetName = targetName;
    }

    @Override
    public void execute() {
        this.royalGroup.killMember(targetName);
    }
}
