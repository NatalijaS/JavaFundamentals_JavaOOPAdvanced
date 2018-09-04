package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.core.ManagementSystem;

public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        {
            return super.getManagementSystem().emergencyReport();
        }
    }
}
