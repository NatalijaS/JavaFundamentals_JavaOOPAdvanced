package exams._2017_07_23_Hell.hell.entities.heroes;

import exams._2017_07_23_Hell.hell.entities.miscellaneous.HeroInventory;
import exams._2017_07_23_Hell.hell.entities.miscellaneous.ItemCollection;
import exams._2017_07_23_Hell.hell.interfaces.Hero;
import exams._2017_07_23_Hell.hell.interfaces.Inventory;
import exams._2017_07_23_Hell.hell.interfaces.Item;
import exams._2017_07_23_Hell.hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public abstract class BaseHero implements Hero, Comparable<Hero> {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence,
                       int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() throws NoSuchFieldException, IllegalAccessException {
        Class<?> inventoryClass = this.inventory.getClass();
        Field[] items = inventoryClass.getDeclaredFields();
        Map<String, Item> inventory = new HashMap<>();
        for (Field item : items) {
            if (item.isAnnotationPresent(ItemCollection.class)) {
                item.setAccessible(true);
                inventory = (Map<String, Item>) item.get(this.inventory);
            }
        }

        return new ArrayList<>(inventory.values());
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d, Damage: %d",
                this.getHitPoints(),
                this.getDamage()))
                .append(System.lineSeparator());
        sb.append(String.format("Strength: %d",
                this.getStrength()))
                .append(System.lineSeparator());
        sb.append(String.format("Agility: %d",
                this.getAgility()))
                .append(System.lineSeparator());
        sb.append(String.format("Intelligence: %d"
                , this.getIntelligence()))
                .append(System.lineSeparator());

        Collection<Item> items = null;
        try {
            items = this.getItems();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append(items.size() == 0 ? "Items: None" : this.getItemsString(items));

        return sb.toString().trim();
    }

    private String getItemsString(Collection<Item> items) {
        StringBuilder sb = new StringBuilder();
        sb.append("Items:").append(System.lineSeparator());
        items.forEach(sb::append);
        return sb.toString();
    }

    @Override
    public int compareTo(Hero hero) {
        long firstHeroSum = this.getStrength() + this.getAgility() + this.getIntelligence();
        long secondHeroSum = hero.getStrength() + hero.getAgility() + hero.getIntelligence();

        if (Long.compare(secondHeroSum, firstHeroSum) == 0) {
            long firstHeroPoints = this.getHitPoints() + this.getDamage();
            long secondHeroPoints = hero.getHitPoints() + hero.getDamage();

            return Long.compare(secondHeroPoints, firstHeroPoints);
        } else {
            return Long.compare(secondHeroSum, firstHeroSum);
        }
    }
}
