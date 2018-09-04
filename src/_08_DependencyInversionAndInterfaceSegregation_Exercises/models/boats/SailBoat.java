package _08_DependencyInversionAndInterfaceSegregation_Exercises.models.boats;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Race;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;

public class SailBoat extends Boat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, false);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double getRaceTime(Race race) {
        return race.getDistance() / ((race.getWindSpeed() * (this.sailEfficiency / 100.0))
                - super.getWeight() + (race.getOceanCurrentSpeed() / 2.0));
    }
}
