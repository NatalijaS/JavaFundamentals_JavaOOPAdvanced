package exams._2018_08_12_CallOfDuty.callofduty.domain.missions;

public class SurveillanceMission extends BaseMission {

    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating - (rating * 0.75d), bounty * 1.5d);
    }
}
