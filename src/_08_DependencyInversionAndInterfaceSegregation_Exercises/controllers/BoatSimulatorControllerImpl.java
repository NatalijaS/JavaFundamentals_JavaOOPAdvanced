package _08_DependencyInversionAndInterfaceSegregation_Exercises.controllers;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.*;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.boats.*;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.engines.BoatEngineImpl;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.races.RaceImpl;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.database.BoatSimulatorDatabase;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.enumeration.EngineType;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.*;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.engines.JetEngine;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private BoatSimulatorDatabase database = BoatSimulatorDatabase.getInstance();
    private Race currentRace;

    private List<Raceable> times;

    public BoatSimulatorControllerImpl() {
        this.setDatabase(this.database);
        this.times = new ArrayList<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    private void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngineImpl engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngineImpl firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BoatEngineImpl secondEngine = this.database.getEngines().getItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngineImpl engine = this.database.getEngines().getItem(engineModel);
        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Raceable> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        this.times = participants;

        List<Raceable> finished = this.times.stream()
                .filter(e -> e.getRaceTime(this.currentRace) > 0.0)
                .sorted(Comparator.comparingDouble(e1 -> e1.getRaceTime(this.currentRace)))
                .limit(3)
                .collect(Collectors.toList());

        List<Raceable> notFinished = new ArrayList<>();

        if (finished.size() < 3) {
            notFinished = this.times.stream()
                    .filter(e -> e.getRaceTime(this.currentRace) <= 0.0)
                    .collect(Collectors.toList());
        }

        StringBuilder result = new StringBuilder();
        String[] places = {"First", "Second", "Third"};

        int position = 0;

        for (Raceable raceable : finished) {
            result.append(String.format("%s place: %s Model: %s Time: %.2f sec",
                    places[position],
                    raceable.getClass().getSimpleName(),
                    raceable.getModel(),
                    raceable.getRaceTime(this.currentRace)));
            result.append(System.lineSeparator());
            position++;
        }

        if (position < 3) {
            for (Raceable raceable : notFinished) {
                result.append(String.format("%s place: %s Model: %s Time: Did not finish!",
                        places[position],
                        raceable.getClass().getSimpleName(),
                        raceable.getModel()));
                result.append(System.lineSeparator());
                position++;
            }
        }

        this.currentRace = null;

        return result.toString();
    }

    @Override
    public String getStatistic() {
        return null;
    }

//    public String getStatistic() {
//        //TODO Bonus Task Implement me
//        throw new NotImplementedException();
//    }


    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
