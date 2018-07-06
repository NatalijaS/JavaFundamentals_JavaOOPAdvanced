package _01_InterfacesAndAbstraction_Exercises._07_FoodShortage;

public class Rebel extends Human {

    Rebel(String name) {
        super(name);
    }

    @Override
    public void buyFood() {
        super.setFood(super.getFood() + 5) ;
    }
}
