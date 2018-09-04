package exams._2017_04_18_Emergency.models.emergencies;

import exams._2017_04_18_Emergency.enums.EmergencyLevel;
import exams._2017_04_18_Emergency.utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel,
                                RegistrationTime registrationTime, Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    @Override
    public Integer getResultAfterProcessing() {
        return this.damage;
    }
}
