package _08_DependencyInversionAndInterfaceSegregation_Exercises.models.boats;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Raceable;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Validator;

public abstract class Boat implements Raceable {

    private String model;
    private int weight;
    private boolean isMotorBoat;

    Boat(String model, int weight, boolean isMotorBoat) {
        this.setModel(model);
        this.setWeight(weight);
        this.isMotorBoat = isMotorBoat;
    }

    @Override
    public boolean isMotorBoat() {
        return isMotorBoat;
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}


