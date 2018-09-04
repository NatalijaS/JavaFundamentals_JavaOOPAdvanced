package exams._2017_07_23_Hell.hell.commands;

import exams._2017_07_23_Hell.hell.annotations.Inject;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.lang.reflect.InvocationTargetException;

public class InspectCommand implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository<Hero> heroRepository;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String heroName = this.data[0];
        Hero hero = this.heroRepository.get(heroName);

        return hero.toString();
    }
}
