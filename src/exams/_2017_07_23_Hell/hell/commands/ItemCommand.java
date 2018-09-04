package exams._2017_07_23_Hell.hell.commands;

import exams._2017_07_23_Hell.hell.annotations.Inject;
import exams._2017_07_23_Hell.hell.factories.ItemFactory;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.interfaces.Item;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.lang.reflect.InvocationTargetException;

public class ItemCommand implements Executable {

    private static final String ADDED_ITEM_TO_HERO_MESSAGE = "Added item - %s to Hero - %s";

    @Inject
    private String[] data;
    @Inject
    private Repository<Hero> heroRepository;

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String itemName = this.data[0];
        String heroName = this.data[1];
        int strengthBonus = Integer.parseInt(this.data[2]);
        int agilityBonus = Integer.parseInt(this.data[3]);
        int intelligenceBonus = Integer.parseInt(this.data[4]);
        int hitPointsBonus = Integer.parseInt(this.data[5]);
        int damageBonus = Integer.parseInt(this.data[6]);

        Item item = ItemFactory.createCommonItem(itemName, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);

        heroRepository.get(heroName).addItem(item);

        return String.format(ADDED_ITEM_TO_HERO_MESSAGE, item.getName(), heroName);
    }
}
