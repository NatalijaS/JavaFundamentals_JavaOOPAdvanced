package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces;
import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.missionsAndRepairs.Mission;

import java.util.List;

public interface ICommando extends ISpecializedSoldier {

    List<Mission> getMissions();

    void addMission(Mission m);
}
