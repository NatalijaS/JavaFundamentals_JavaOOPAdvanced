package _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.employees;

public abstract class Employee {

    private String name;
    private int workingHoursPerWeek;

    public Employee(String name, int workingHoursPerWeek) {
        this.name = name;
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    public int getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }
}
