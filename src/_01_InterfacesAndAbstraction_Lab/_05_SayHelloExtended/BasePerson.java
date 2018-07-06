package _01_InterfacesAndAbstraction_Lab._05_SayHelloExtended;

public abstract class BasePerson {
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
