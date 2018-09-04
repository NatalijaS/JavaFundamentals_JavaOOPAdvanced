package exams._2017_04_18_Emergency.models.emergencies;

import exams._2017_04_18_Emergency.enums.EmergencyLevel;
import exams._2017_04_18_Emergency.utils.RegistrationTime;

public interface Emergency {

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    Integer getResultAfterProcessing();
}
