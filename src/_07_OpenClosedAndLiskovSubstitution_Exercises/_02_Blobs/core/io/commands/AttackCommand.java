package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.commands;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Blobable;

public class AttackCommand extends Command {

    private BlobRepository blobRepository;

    public AttackCommand(String[] data) {
        super(data);
    }

    @Override
    public void execute(String[] params) {
        Blobable attacker = blobRepository.returnBlob(params[1]);
        Blobable target = blobRepository.returnBlob(params[2]);
        attacker.attack(attacker, target);
        this.blobRepository.passTurn();
    }
}
