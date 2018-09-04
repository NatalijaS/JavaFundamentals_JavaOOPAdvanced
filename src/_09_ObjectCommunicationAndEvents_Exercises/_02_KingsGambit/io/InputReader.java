package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.RoyalGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private static final String END_COMMAND = "End";

    private CommandExecutor commandExecutor;
    private RoyalGroup royalGroup;

    public InputReader(CommandExecutor commandExecutor, RoyalGroup royalGroup) {
        this.commandExecutor = commandExecutor;
        this.royalGroup = royalGroup;
    }

    public void readCommands() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input ;
        while (!END_COMMAND.equals(input = reader.readLine())){
            String[] data = input.split("\\s+");
            commandExecutor.executeCommand(data, this.royalGroup);
        }

    }
}
