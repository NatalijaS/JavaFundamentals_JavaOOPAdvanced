package _08_DependencyInversionAndInterfaceSegregation_Exercises.models.boats;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.BoatEngine;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Race;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Validator;

public class Yacht extends Boat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine boatEngine, int cargoWeight) {
        super(model, weight, true);
        this.setBoatEngine(boatEngine);
        this.setCargoWeight(cargoWeight);
    }

    private void setBoatEngine(BoatEngine boatEngine) {
        if (boatEngine == null) {
            throw new IllegalArgumentException();
        }
        this.boatEngine = boatEngine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double getRaceTime(Race race) {
        return race.getDistance() / (this.boatEngine.getOutput()
                - (super.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2.0));
    }
}
