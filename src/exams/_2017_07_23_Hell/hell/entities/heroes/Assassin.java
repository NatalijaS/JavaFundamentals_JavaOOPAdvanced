package exams._2017_07_23_Hell.hell.entities.heroes;

public class Assassin extends BaseHero {

    private static final int DEFAULT_STRENGTH = 25;
    private static final int DEFAULT_AGILITY = 100;
    private static final int DEFAULT_INTELLIGENCE = 15;
    private static final int DEFAULT_HIT_POINTS = 150;
    private static final int DEFAULT_DAMAGE = 300;

    protected Assassin(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE, DEFAULT_HIT_POINTS, DEFAULT_DAMAGE);
    }
}
