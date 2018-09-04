package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io.InputReader;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models.King;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models.RoyalGuard;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.CommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] kingName = reader.readLine().split("\\s+");
        String[] royalGuardsName = reader.readLine().split("\\s+");
        String[] footmenNames = reader.readLine().split("\\s+");
        RoyalGroup royalGroup = new RoyalGroup();
        King king = new King(kingName[0]);
        royalGroup.addMember(king);


        CommandExecutor commandExecutor = new CommandExecutor();

    }
}
