package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.annotations.InjectArgs;
import exams._2017_04_18_Emergency.core.ManagementSystem;
import exams._2017_04_18_Emergency.enums.EmergencyLevel;
import exams._2017_04_18_Emergency.enums.Status;
import exams._2017_04_18_Emergency.models.emergencies.Emergency;
import exams._2017_04_18_Emergency.models.emergencies.OrderEmergency;
import exams._2017_04_18_Emergency.utils.RegistrationTime;
import exams._2017_04_18_Emergency.utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] data;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.data[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.data[2].toUpperCase());
        String statusValue = this.data[4].replaceAll("-","_").toUpperCase();
        Status status = Status.valueOf(statusValue);
        this.createRegistrationTime(this.data[3]);
        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
