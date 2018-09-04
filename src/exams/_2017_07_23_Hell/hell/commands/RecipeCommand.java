package exams._2017_07_23_Hell.hell.commands;

import exams._2017_07_23_Hell.hell.annotations.Inject;
import exams._2017_07_23_Hell.hell.entities.items.RecipeItem;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.interfaces.Recipe;
import exams._2017_07_23_Hell.hell.repository.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeCommand implements Executable {

    private static final String ADDED_RECIPE_TO_HERO_MESSAGE = "Added recipe - %s to Hero - %s";

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

        List<String> requiredItems = new ArrayList<>();

        requiredItems.addAll(Arrays.asList(this.data).subList(7, this.data.length));

        Recipe recipe = new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus,
                requiredItems.toArray(new String[requiredItems.size()]));

        this.heroRepository.get(heroName).addRecipe(recipe);


        return String.format(ADDED_RECIPE_TO_HERO_MESSAGE, recipe.getName(), heroName);
    }
}
