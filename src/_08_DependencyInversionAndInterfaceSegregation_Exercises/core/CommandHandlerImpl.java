package _08_DependencyInversionAndInterfaceSegregation_Exercises.core;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.CommandHandler;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.utility.Constants;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.BoatSimulatorController;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.enumeration.EngineType;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.exeptions.*;

import java.util.List;

public class CommandHandlerImpl implements CommandHandler {

    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.setController(controller);
    }

    private void setController(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String name, List<String> parameters)
            throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException,
            NoSetRaceException, InsufficientContestantsException {

        switch (name) {

            case "CreateBoatEngine":
                try {
                    return this.controller.createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.valueOf(parameters.get(3).toUpperCase()));
                } catch (IllegalArgumentException iae) {
                    throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
                }

            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));

            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));

            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));

            case "CreateYacht":
                return this.controller.createYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));

            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));

            case "SignUpBoat":
                return this.controller.signUpBoat(parameters.get(0));

            case "StartRace":
                return this.controller.startRace();

            case "GetStatistic":
                return this.controller.getStatistic();

            default:
                throw new IllegalArgumentException();
        }
    }
}
