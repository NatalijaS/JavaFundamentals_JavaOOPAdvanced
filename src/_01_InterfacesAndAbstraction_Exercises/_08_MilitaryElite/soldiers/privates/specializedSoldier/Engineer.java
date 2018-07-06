package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.soldiers.privates.specializedSoldier;

import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces.IEngineer;
import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.missionsAndRepairs.Repair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public void addRepair(Repair r) {
        this.repairs.add(r);
    }

    @Override
    public String toString() {
        StringBuilder repairsToString = new StringBuilder();
        repairsToString.append("Repairs:\n");
        this.repairs.forEach(repairsToString::append);
        return super.toString() + repairsToString;
    }
}