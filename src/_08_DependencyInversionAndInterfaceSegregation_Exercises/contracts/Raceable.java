package _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts;

public interface Raceable extends Modelable {

    double getRaceTime(Race race);

    boolean isMotorBoat();
}
