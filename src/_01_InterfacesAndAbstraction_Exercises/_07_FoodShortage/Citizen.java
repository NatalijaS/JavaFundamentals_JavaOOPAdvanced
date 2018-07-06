package _01_InterfacesAndAbstraction_Exercises._07_FoodShortage;

public class Citizen extends Human {

    Citizen(String name) {
        super(name);
    }


    @Override
    public void buyFood() {
        super.setFood(super.getFood() + 10);
    }
}
