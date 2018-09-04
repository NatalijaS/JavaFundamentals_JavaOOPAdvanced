package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.models.attacks;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Attack;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.models.Blob;

public abstract class AbstractAttack implements Attack {
    public abstract void execute(Blob attacker, Blob target);
}
