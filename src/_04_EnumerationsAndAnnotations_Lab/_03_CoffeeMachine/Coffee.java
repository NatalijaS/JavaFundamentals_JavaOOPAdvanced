package _04_EnumerationsAndAnnotations_Lab._03_CoffeeMachine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(CoffeeSize size, CoffeeType type) {
        this.size = size;
        this.type = type;
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    public CoffeeType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.size + " " + this.type;
    }
}
