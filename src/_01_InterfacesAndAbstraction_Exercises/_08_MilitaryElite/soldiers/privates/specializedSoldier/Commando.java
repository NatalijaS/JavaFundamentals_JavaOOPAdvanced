package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.soldiers.privates.specializedSoldier;

import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces.ICommando;
import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.missionsAndRepairs.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public void addMission(Mission m) {
        this.missions.add(m);
    }

    @Override
    public String toString() {
        StringBuilder missionsToString = new StringBuilder();
        missionsToString.append("Missions:\n");
        this.missions.forEach(missionsToString::append);
        return super.toString() + missionsToString;
    }
}