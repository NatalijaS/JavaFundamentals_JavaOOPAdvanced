package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.models.behavors;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Blobable;

public class Aggressive extends AbstractBehavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    @Override
    public void trigger(Blobable source) {
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blobable source) {
        if(this.isTriggered()) {
            source.updateDamage(source.getDamage() + AGGRESSIVE_DAMAGE_DECREMENT);
        }
    }

    private void applyTriggerEffect(Blobable source) {
        source.updateDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }
}
