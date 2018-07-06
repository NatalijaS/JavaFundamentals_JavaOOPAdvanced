package _05_Reflection_Exercises._03_04_Barracks.core.commands;

import _05_Reflection_Exercises._03_04_Barracks.contracts.Executable;
import _05_Reflection_Exercises._03_04_Barracks.contracts.Repository;
import _05_Reflection_Exercises._03_04_Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    String[] getData() {
        return data;
    }

    Repository getRepository() {
        return repository;
    }

    UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
