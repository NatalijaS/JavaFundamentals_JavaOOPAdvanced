package exams._2018_08_12_CallOfDuty.callofduty.interfaces;

public interface Agent extends Identifiable, Nameable, Rateable {

    void acceptMission(Mission mission);

    void completeMissions() throws NoSuchFieldException, IllegalAccessException;
}
