package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.annotations.InjectType;
import exams._2017_04_18_Emergency.core.ManagementSystem;

public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectType
    private String type;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
