package exams._2017_07_23_Hell.hell.entities.heroes;

public class Barbarian extends BaseHero {

    private static final int DEFAULT_STRENGTH = 90;
    private static final int DEFAULT_AGILITY = 25;
    private static final int DEFAULT_INTELLIGENCE = 10;
    private static final int DEFAULT_HIT_POINTS = 350;
    private static final int DEFAULT_DAMAGE = 150;

    public Barbarian(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HIT_POINTS, DEFAULT_DAMAGE);
    }
}
