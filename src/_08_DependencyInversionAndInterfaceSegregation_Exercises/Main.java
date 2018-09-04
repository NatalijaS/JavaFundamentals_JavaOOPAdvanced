package _08_DependencyInversionAndInterfaceSegregation_Exercises;

import _08_DependencyInversionAndInterfaceSegregation_Exercises.contracts.BoatSimulatorController;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.controllers.BoatSimulatorControllerImpl;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.core.CommandHandlerImpl;
import _08_DependencyInversionAndInterfaceSegregation_Exercises.core.Engine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BoatSimulatorController controller = new BoatSimulatorControllerImpl();
        CommandHandlerImpl commandHandlerImpl = new CommandHandlerImpl(controller);
        Engine engine = new Engine(commandHandlerImpl);
        engine.run();
    }
}
