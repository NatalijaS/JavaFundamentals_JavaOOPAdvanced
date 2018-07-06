package _01_InterfacesAndAbstraction_Lab._05_SayHelloExtended;

public class Chinese extends BasePerson implements Person {
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return null;
    }
}
