package exams._2017_07_23_Hell.hell.repository;

import exams._2017_07_23_Hell.hell.interfaces.Hero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository implements Repository<Hero> {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void add(Hero element) {
        this.heroes.put(element.getName(), element);
    }

    @Override
    public void remove(Hero element) {
        this.heroes.remove(element.getName());
    }

    @Override
    public Hero get(String elementName) {
        return this.heroes.get(elementName);
    }

    @Override
    public Collection<Hero> getAll() {
        return new ArrayList<>(this.heroes.values());
    }
}
