package _08_DependencyInversionAndInterfaceSegregation_Exercises.models.engines;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.BoatEngine;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Validator;

public abstract class BoatEngineImpl implements BoatEngine {

    private String model;
    private int horsepower;
    private int displacement;

    BoatEngineImpl(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    int getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
