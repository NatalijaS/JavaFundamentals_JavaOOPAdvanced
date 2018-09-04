package _08_DependencyInversionAndInterfaceSegregation_Lab._04_Recharge;

public class Employee extends Worker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    public void sleep() {
        // sleep...
    }
}
