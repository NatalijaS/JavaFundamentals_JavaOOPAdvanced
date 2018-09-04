package exams._2017_07_23_Hell.hell;

import exams._2017_07_23_Hell.hell.core.Engine;
import exams._2017_07_23_Hell.hell.factories.Factory;
import exams._2017_07_23_Hell.hell.factories.HeroFactory;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.interfaces.InputReader;
import exams._2017_07_23_Hell.hell.interfaces.OutputWriter;
import exams._2017_07_23_Hell.hell.interpreter.CommandInterpreter;
import exams._2017_07_23_Hell.hell.interpreter.Interpreter;
import exams._2017_07_23_Hell.hell.io.ConsoleReader;
import exams._2017_07_23_Hell.hell.io.ConsoleWriter;
import exams._2017_07_23_Hell.hell.repository.HeroRepository;
import exams._2017_07_23_Hell.hell.repository.Repository;

public class Main {

    public static void main(String[] args) {

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        Repository<Hero> heroRepository = new HeroRepository();
        Factory<Hero> heroFactory = new HeroFactory("exams._2017_07_23_Hell.hell.entities.heroes.");

        Interpreter commandInterpreter = new CommandInterpreter(heroRepository, heroFactory);

        Runnable engine = new Engine(reader, writer, heroRepository, commandInterpreter);

        engine.run();
    }
}