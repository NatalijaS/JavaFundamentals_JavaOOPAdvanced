package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces;

import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.missionsAndRepairs.Repair;

import java.util.List;

public interface IEngineer extends ISpecializedSoldier {

    List<Repair> getRepairs();

    void addRepair(Repair r);
}
