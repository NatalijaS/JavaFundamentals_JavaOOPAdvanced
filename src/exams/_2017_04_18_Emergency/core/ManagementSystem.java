package exams._2017_04_18_Emergency.core;

import exams._2017_04_18_Emergency.models.centers.EmergencyCenter;
import exams._2017_04_18_Emergency.models.emergencies.Emergency;

public interface ManagementSystem {

    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter emergencyCenter);

    String registerMedicalServiceCenter(EmergencyCenter emergencyCenter);

    String registerPoliceServiceCenter(EmergencyCenter emergencyCenter);

    String processEmergencies(String type);

    String emergencyReport();
}
