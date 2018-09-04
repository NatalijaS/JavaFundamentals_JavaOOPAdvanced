package exams._2018_08_12_CallOfDuty.callofduty.domain.missions;

public class EscortMission extends BaseMission {

    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating - (rating * 0.25d), bounty * 1.25d);
    }
}
