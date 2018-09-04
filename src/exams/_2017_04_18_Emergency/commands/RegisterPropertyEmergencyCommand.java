package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.annotations.InjectArgs;
import exams._2017_04_18_Emergency.core.ManagementSystem;
import exams._2017_04_18_Emergency.enums.EmergencyLevel;
import exams._2017_04_18_Emergency.models.emergencies.Emergency;
import exams._2017_04_18_Emergency.models.emergencies.PropertyEmergency;
import exams._2017_04_18_Emergency.utils.RegistrationTime;
import exams._2017_04_18_Emergency.utils.RegistrationTimeImpl;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] data;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.data[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.data[2].toUpperCase());
        Integer propertyDamage = Integer.valueOf(this.data[4]);
        this.createRegistrationTime(this.data[3]);
        this.emergency = new PropertyEmergency(description, level, this.registrationTime, propertyDamage);
        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
