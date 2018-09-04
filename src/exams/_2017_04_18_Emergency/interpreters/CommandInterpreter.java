package exams._2017_04_18_Emergency.interpreters;

import exams._2017_04_18_Emergency.annotations.InjectArgs;
import exams._2017_04_18_Emergency.annotations.InjectType;
import exams._2017_04_18_Emergency.commands.Executable;
import exams._2017_04_18_Emergency.core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_PACKAGE = "exams._2017_04_18_Emergency.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable executable = null;
        String[] data = line.split("\\|+");
        String commandName = data[0];

        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PACKAGE + commandName + COMMAND_SUFFIX);
        Constructor<Executable> commandConstructor = commandClass.getDeclaredConstructor(ManagementSystem.class);

        executable = commandConstructor.newInstance(this.managementSystem);

        this.injectDependencies(executable, data);
        return executable;
    }

    private void injectDependencies(Executable executable, String[] data) throws IllegalAccessException {
        Field [] fields = executable.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(executable,data);
                return;
            } else if (field.isAnnotationPresent(InjectType.class)) {
                field.setAccessible(true);
                field.set(executable,data[1]);
                return;
            }
        }
    }
}
