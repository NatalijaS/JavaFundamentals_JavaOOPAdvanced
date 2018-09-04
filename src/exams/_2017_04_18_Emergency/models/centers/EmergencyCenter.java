package exams._2017_04_18_Emergency.models.centers;

public interface EmergencyCenter {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Integer getProcessedEmergencies();

    void processEmergency();

    Boolean isForRetirement();
}
