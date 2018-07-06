package _01_InterfacesAndAbstraction_Exercises._05_BorderControl;

public class Person implements Identity{

    private String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return this.id;
    }
}
