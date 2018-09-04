package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.RoyalGroup;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.commands.AttackCommand;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.commands.Command;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.commands.KillCommand;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(String[] data, RoyalGroup royalGroup) {
        String commandName = data[0];

        Command command = null;
        switch (commandName) {
            case "Kill":
                command = new KillCommand(royalGroup, data[1]);
                command.execute();
                break;
            case "Attack":
                command = new AttackCommand(royalGroup);
                command.execute();
                break;
        }

    }
}
