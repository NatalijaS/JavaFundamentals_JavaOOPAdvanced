package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces;

public interface Behavior {

    void trigger(Blobable source);

    void applyRecurrentEffect(Blobable source);

    boolean isTriggered();

}
