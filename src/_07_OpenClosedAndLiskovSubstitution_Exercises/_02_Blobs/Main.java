package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.AttackFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.BehaviorFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.CommandInterpreter;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.InputReader;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.OutputWriter;

public class Main {
    public static void main(String[] args) {
        BehaviorFactory behaviorFactory = new BehaviorFactory();
        AttackFactory attackFactory = new AttackFactory();
        BlobRepository blobRepository = new BlobRepository();
        OutputWriter outputWriter = new OutputWriter();
        CommandInterpreter commandInterpreter = new CommandInterpreter(blobRepository, outputWriter, attackFactory, behaviorFactory);
        InputReader inputReader = new InputReader(commandInterpreter, outputWriter);
        try {
            inputReader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
