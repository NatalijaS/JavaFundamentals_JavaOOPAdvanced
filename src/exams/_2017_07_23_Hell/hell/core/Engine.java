package exams._2017_07_23_Hell.hell.core;

import exams._2017_07_23_Hell.hell.commands.Executable;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.interfaces.InputReader;
import exams._2017_07_23_Hell.hell.interfaces.Item;
import exams._2017_07_23_Hell.hell.interfaces.OutputWriter;
import exams._2017_07_23_Hell.hell.interpreter.Interpreter;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Repository<Hero> heroRepository;
    private Interpreter commandInterpreter;

    public Engine(InputReader reader, OutputWriter writer, Repository<Hero> heroRepository, Interpreter commandInterpreter) {
        this.reader = reader;
        this.writer = writer;
        this.heroRepository = heroRepository;
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        String commandLine;
        try {
            while (!"Quit".equals(commandLine = this.reader.readLine())){
                Executable command = this.commandInterpreter.interpretCommand(commandLine);
                String result = command.execute();

                this.writer.writeLine(result);
            }
        } catch (IOException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        String quitResult = this.getResultsString();

        this.writer.writeLine(quitResult);
    }

    private String getResultsString() {
        StringBuilder sb = new StringBuilder();

        final int[] heroIndex = {0};

        this.heroRepository.getAll().stream().sorted().forEach(hero -> {
            sb.append(String.format("%d. %s: %s", ++heroIndex[0], hero.getClass().getSimpleName(),
                    hero.getName())).append(System.lineSeparator());
            sb.append(String.format("###HitPoints: %s", hero.getHitPoints())).append(System.lineSeparator());
            sb.append(String.format("###Damage: %s", hero.getDamage())).append(System.lineSeparator());
            sb.append(String.format("###Strength: %s", hero.getStrength())).append(System.lineSeparator());
            sb.append(String.format("###Agility: %s", hero.getAgility())).append(System.lineSeparator());
            sb.append(String.format("###Intelligence: %s", hero.getIntelligence())).append(System.lineSeparator());

            Collection<Item> items = null;
            try {
                items = hero.getItems();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append("###Items: ");
            sb.append(items.size() == 0 ? "None" :
                    String.join(", ", items.stream().map(Item::getName).collect(Collectors.toList())))
                    .append(System.lineSeparator());
        });

        return sb.toString();
    }
}
