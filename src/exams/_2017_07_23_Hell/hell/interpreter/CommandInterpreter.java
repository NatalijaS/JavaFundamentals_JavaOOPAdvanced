package exams._2017_07_23_Hell.hell.interpreter;

import exams._2017_07_23_Hell.hell.annotations.Inject;
import exams._2017_07_23_Hell.hell.commands.Executable;
import exams._2017_07_23_Hell.hell.factories.Factory;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PACKAGE = "exams._2017_07_23_Hell.hell.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private String[] data;
    private Repository<Hero> heroRepository;
    private Factory<Hero> heroFactory;

    public CommandInterpreter(Repository<Hero> heroRepository, Factory<Hero> heroFactory) {
        this.heroRepository = heroRepository;
        this.heroFactory = heroFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String commandLine) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String[] commandArgs = commandLine.split(" ");
        String commandType = commandArgs[0];

        this.data = Arrays.stream(commandArgs).skip(1).toArray(String[]::new);

        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandType + COMMAND_SUFFIX);
        Executable command = commandClass.newInstance();

        this.injectDependencies(command, commandClass);

        return command;
    }

    private void injectDependencies(Executable command, Class<Executable> commandClass) throws IllegalAccessException {
        Field[] clientFields = commandClass.getDeclaredFields();
        for (Field clientField : clientFields) {
            if (! clientField.isAnnotationPresent(Inject.class)) continue;
            clientField.setAccessible(true);

            Field[] serviceFields = this.getClass().getDeclaredFields();
            for (Field serviceField : serviceFields) {
                if (! serviceField.getType().equals(clientField.getType())) continue;
                serviceField.setAccessible(true);

                clientField.set(command, serviceField.get(this));
            }
        }
    }
}
