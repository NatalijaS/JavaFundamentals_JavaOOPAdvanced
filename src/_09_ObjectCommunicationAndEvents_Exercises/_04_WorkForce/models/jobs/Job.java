package _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.jobs;

import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.contracts.JobCompletedListener;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.models.employees.Employee;
import _09_ObjectCommunicationAndEvents_Exercises._04_WorkForce.events.JobCompletedEvent;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private List<JobCompletedListener> observers;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getWorkHoursRequired() {
        return hoursOfWorkRequired;
    }

    private void setWorkHoursRequired(int workHoursRequired) {
        this.hoursOfWorkRequired = workHoursRequired;
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void addJobCompletedListener(JobCompletedListener listener){
        this.observers.add(listener);
    }

    public void update(){
        this.setWorkHoursRequired(this.getWorkHoursRequired() - this.employee.getWorkingHoursPerWeek());
        if(this.getWorkHoursRequired() <= 0){
            System.out.println(String.format("Job %s done!",this.getName()));
            this.fireJobCompletedEvent();
        }
    }

    private void fireJobCompletedEvent(){
        JobCompletedEvent event = new JobCompletedEvent(this);
        for (JobCompletedListener observer : observers) {
            observer.handleJobCompleted(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",this.getName(),this.getWorkHoursRequired());
    }
}
