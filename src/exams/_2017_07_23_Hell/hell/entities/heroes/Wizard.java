package exams._2017_07_23_Hell.hell.entities.heroes;

public class Wizard extends BaseHero{

    private static final int DEFAULT_STRENGTH = 25;
    private static final int DEFAULT_AGILITY = 25;
    private static final int DEFAULT_INTELLIGENCE = 100;
    private static final int DEFAULT_HIT_POINTS = 100;
    private static final int DEFAULT_DAMAGE = 250;

    protected Wizard(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HIT_POINTS, DEFAULT_DAMAGE);
    }
}
