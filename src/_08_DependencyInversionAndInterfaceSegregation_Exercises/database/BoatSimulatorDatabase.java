package _08_DependencyInversionAndInterfaceSegregation_Exercises.database;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.Repository;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.boats.Boat;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.engines.BoatEngineImpl;

public class BoatSimulatorDatabase {

    private static BoatSimulatorDatabase INSTANCE = null;

    private Repository<Boat> boats;
    private Repository<BoatEngineImpl> engines;

    private BoatSimulatorDatabase() {
        this.boats = new RepositoryImpl<>();
        this.engines = new RepositoryImpl<>();
    }

    public static BoatSimulatorDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BoatSimulatorDatabase();
        }
        return INSTANCE;
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<BoatEngineImpl> getEngines() {
        return this.engines;
    }
}
