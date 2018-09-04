package _08_DependencyInversionAndInterfaceSegregation_Lab._04_Recharge;

public abstract class Worker {

    private String id;
    private int workingHours;

    public Worker(String id) {
        this.id = id;
    }

    public void work(int hours) {
        this.workingHours += hours;
    }
}
