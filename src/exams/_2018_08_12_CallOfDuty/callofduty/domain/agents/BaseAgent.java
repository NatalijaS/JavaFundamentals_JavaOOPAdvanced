package exams._2018_08_12_CallOfDuty.callofduty.domain.agents;

import exams._2018_08_12_CallOfDuty.callofduty.core.MissionControlImpl;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Agent;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Mission;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.MissionControl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public  abstract class BaseAgent implements Agent{

    private String id;
    private String name;
    private Double rating;

    private MissionControl missionControl;
    private List<Mission> completedMissions;
    private List<Mission> missionsToComplete;

    protected BaseAgent(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missionControl =  new MissionControlImpl();
        this.completedMissions = new ArrayList<>();
        this.missionsToComplete = new ArrayList<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.missionsToComplete.add(mission);
    }

    @Override
    public void completeMissions() throws NoSuchFieldException, IllegalAccessException {
        this.completedMissions.addAll(this.missionsToComplete);
        for (Mission mission : missionsToComplete) {
            Class<?> missionClass = mission.getClass().getSuperclass();
            Field status = missionClass.getDeclaredField("status");
            status.setAccessible(true);
            status.set(mission, "Completed");
        }
        for (Mission mission : missionsToComplete) {
            rating += mission.getRating();

            earnBounty(mission.getBounty());
        }
        this.missionsToComplete.clear();
    }

    protected abstract void earnBounty(Double bounty);

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName().replace("Agent", " Agent")
                + " - " + this.getName() +
                System.lineSeparator() +
                String.format("Personal Code: %s", this.getId()) +
                System.lineSeparator() +
                String.format("Assigned Missions: %d", this.missionsToComplete.size()) +
                System.lineSeparator() +
                String.format("Completed Missions: %d", this.completedMissions.size()) +
                System.lineSeparator() +
                String.format("Rating: %.2f", this.getRating());
    }
}
