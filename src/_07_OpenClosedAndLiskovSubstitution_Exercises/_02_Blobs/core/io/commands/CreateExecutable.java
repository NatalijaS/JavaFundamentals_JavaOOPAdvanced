package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.commands;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.AttackFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.BehaviorFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Attack;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Behavior;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.models.Blob;

public class CreateExecutable extends Command {


    private BlobRepository blobRepository;

    private AttackFactory attackFactory;

    private BehaviorFactory behaviorFactory;

    public CreateExecutable(String[] data) {
        super(data);
    }

    @Override
    public void execute(String[] params) {
        String name = params[1];
        int health = Integer.parseInt(params[2]);
        int damage = Integer.parseInt(params[3]);
        Behavior behavior = this.behaviorFactory.returnObject(params[4]);
        Attack attack = this.attackFactory.returnObject(params[5]);
        blobRepository.addBlob(new Blob(name, health, damage, behavior, attack));
        this.blobRepository.passTurn();
    }
}
