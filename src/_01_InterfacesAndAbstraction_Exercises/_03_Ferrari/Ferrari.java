package _01_InterfacesAndAbstraction_Exercises._03_Ferrari;

public class Ferrari implements Car{
    String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getModel() {
        return model;
    }
}
