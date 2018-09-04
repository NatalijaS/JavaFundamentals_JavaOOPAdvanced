package _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.DuplicateModelException;

import java.util.List;

public interface Race {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    boolean getAllowsMotorboats();

    void addParticipant(Raceable boat) throws DuplicateModelException;

    List<Raceable> getParticipants();
}
