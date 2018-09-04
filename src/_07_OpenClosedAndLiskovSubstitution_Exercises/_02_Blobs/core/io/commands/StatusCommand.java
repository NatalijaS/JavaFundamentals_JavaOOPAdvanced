package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.commands;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.OutputWriter;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Blobable;

public class StatusCommand extends Command {


    private OutputWriter outputWriter;


    private BlobRepository blobRepository;

    public StatusCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute(String[] params) {
        for (Blobable blobable : blobRepository.returnAllBlobs()) {
            outputWriter.writeMessage(blobable.toString());
        }
        this.blobRepository.passTurn();
    }
}
