package exams._2017_04_18_Emergency.models.emergencies;

import exams._2017_04_18_Emergency.enums.EmergencyLevel;
import exams._2017_04_18_Emergency.utils.RegistrationTime;

public abstract class BaseEmergency implements Emergency{

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTime;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }


    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public RegistrationTime getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
