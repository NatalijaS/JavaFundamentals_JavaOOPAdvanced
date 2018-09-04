package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.commands;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;

public class PassCommand extends Command {


    private BlobRepository blobRepository;

    public PassCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute(String[] params) {
        this.blobRepository.passTurn();
    }
}
