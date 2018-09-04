package exams._2018_08_12_CallOfDuty.callofduty.domain.missions;

public class HuntMission extends BaseMission {

    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating * 1.5d, bounty * 2.0d);
    }
}
