package exams._2017_07_23_Hell.hell.factories;

import exams._2017_07_23_Hell.hell.entities.items.CommonItem;
import exams._2017_07_23_Hell.hell.interfaces.Item;

public final class ItemFactory {

    private ItemFactory(){}

    public static Item createCommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                                        int hitPointsBonus, int damageBonus){
        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }
}
