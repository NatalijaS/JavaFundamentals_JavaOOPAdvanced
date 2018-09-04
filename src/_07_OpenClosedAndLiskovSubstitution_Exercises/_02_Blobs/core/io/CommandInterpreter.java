package _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io;

import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.annotations.Alias;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.annotations.Inject;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.BlobRepository;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.AttackFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.factories.BehaviorFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.core.io.commands.Command;
import _07_OpenClosedAndLiskovSubstitution_Exercises._02_Blobs.interfaces.Executable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter {

    private static final String COMMAND_LOCATION = "src/core/io/commands";


    private BlobRepository blobRepository;
    private OutputWriter outputWriter;
    private AttackFactory attackFactory;
    private BehaviorFactory behaviorFactory;

    public CommandInterpreter(BlobRepository blobRepository, OutputWriter outputWriter, AttackFactory attackFactory, BehaviorFactory behaviorFactory) {
        this.blobRepository = blobRepository;
        this.outputWriter = outputWriter;
        this.attackFactory = attackFactory;
        this.behaviorFactory = behaviorFactory;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(data, commandName);
            command.execute(data);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private Executable parseCommand(String[] data, String command) {
        String fullName = Command.class.getName();
        int index = fullName.lastIndexOf(".") + 1;
        String packageName = fullName.substring(0, index);
        File commandFolder = new File(COMMAND_LOCATION);
        Executable executable = null;

        for (File file : commandFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }
            try {
                String className = file.getName().substring(0, file.getName().lastIndexOf("."));

                Class<Executable> exeClass = (Class<Executable>) Class.forName(packageName + className);

                if(!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();

                if(!value.equalsIgnoreCase(command)) {
                    continue;
                }

                Constructor exeCtor = exeClass.getConstructor(String[].class);
                executable = (Executable) exeCtor.newInstance((Object) data);
                this.injectDependencies(executable, exeClass);
            } catch (ReflectiveOperationException rfoe) {
                rfoe.printStackTrace();
            }
        }
        return executable;
    }

    private void injectDependencies(Executable executable, Class<Executable> exeClass) throws IllegalAccessException {
        Field[] exeFields = exeClass.getDeclaredFields();
        for (Field exeField : exeFields) {
            if(!exeField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            exeField.setAccessible(true);
            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : theseFields) {
                if(!thisField.getType().equals(exeField.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                exeField.set(executable, thisField.get(this));
            }
        }
    }
}
