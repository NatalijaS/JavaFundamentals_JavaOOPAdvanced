package designPatterns.strategyPattern;

public class AnimalPlay {

    public static void main(String[] args){
        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFlay());
        System.out.println("Bird: " + tweety.tryToFlay());

        // This allows dynamic changes for flyingType
        sparky.setFlayingAbility(new ItFlays());
        System.out.println("Dog: " + sparky.tryToFlay());
    }
}
