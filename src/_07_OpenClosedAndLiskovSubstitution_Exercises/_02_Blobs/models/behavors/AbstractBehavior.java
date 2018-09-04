package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.models.behavors;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;


    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }
}
