package exams._2017_07_23_Hell.hell.commands;

import exams._2017_07_23_Hell.hell.annotations.Inject;
import exams._2017_07_23_Hell.hell.factories.Factory;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.lang.reflect.InvocationTargetException;

public class HeroCommand implements Executable {

    private static final String CREATED_HERO_MESSAGE = "Created %s - %s";

    @Inject
    private String[] data;
    @Inject
    private Factory<Hero> heroFactory;
    @Inject
    private Repository<Hero> heroRepository;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Hero hero = heroFactory.create(data);
        this.heroRepository.add(hero);

        return String.format(CREATED_HERO_MESSAGE, hero.getClass().getSimpleName(), hero.getName());
    }
}
