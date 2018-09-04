package exams._2017_07_23_Hell.hell.entities.items;

import exams._2017_07_23_Hell.hell.interfaces.Recipe;

import java.util.*;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> commonItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                      int hitPointsBonus, int damageBonus, String... commonItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.commonItems = Arrays.asList(commonItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.commonItems;
    }
}
