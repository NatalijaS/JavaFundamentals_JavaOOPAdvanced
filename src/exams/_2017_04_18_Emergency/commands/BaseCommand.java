package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.core.ManagementSystem;

public abstract class BaseCommand implements Executable {

    private ManagementSystem managementSystem;

    protected BaseCommand(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    protected ManagementSystem getManagementSystem() {
        return this.managementSystem;
    }
}
