package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces;

import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.soldiers.privates.Private;

import java.util.List;

public interface ILeutenanatGeneral extends IPrivate {

    void addPrivate(Private p);

    List<Private> getPrivates();
}