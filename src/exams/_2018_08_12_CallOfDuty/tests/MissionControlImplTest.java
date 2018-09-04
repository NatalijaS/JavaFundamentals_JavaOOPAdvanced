package exams._2018_08_12_CallOfDuty.tests;

import exams._2018_08_12_CallOfDuty.callofduty.core.MissionControlImpl;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Mission;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissionControlImplTest {

    private static final String ID_IN_BOUNDARIES = "123";
    private static final String ID_ABOVE_BOUNDARIES = "123456789";
    private static final Double RATING_AND_BOUNTY_IN_BOUNDARIES = 100D;
    private static final Double RATING_AND_BOUNTY_BELOW_BOUNDARIES = -100D;
    private static final Double RATING_ABOVE_BOUNDARIES = 1000D;
    private static final Double BOUNTY_ABOVE_BOUNDARIES = 1000000D;

    private MissionControl missionControl;

    @Before
    public void setUp() throws Exception {
        this.missionControl = new MissionControlImpl();
    }

    @Test
    public void testInBoundaries() {
        Mission mission;

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_IN_BOUNDARIES, RATING_AND_BOUNTY_IN_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 1.25, mission.getBounty(), 0.00);

        // HuntMission - rating*1.5, bounty*2
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_IN_BOUNDARIES, RATING_AND_BOUNTY_IN_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.HuntMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 1.5, mission.getRating(), 0.00);
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 2, mission.getBounty(), 0.00);

        // SurveillanceMission - rating * 0.25, bounty * 1.5
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_IN_BOUNDARIES, RATING_AND_BOUNTY_IN_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 0.25, mission.getRating(), 0.00);
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 1.5, mission.getBounty(), 0.00);

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_IN_BOUNDARIES, RATING_AND_BOUNTY_IN_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(RATING_AND_BOUNTY_IN_BOUNDARIES * 1.25, mission.getBounty(), 0.00);
    }

    @Test
    public void testUnderBoundaries() {
        Mission mission;

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_BELOW_BOUNDARIES, RATING_AND_BOUNTY_BELOW_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(0D * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(0D * 1.25, mission.getBounty(), 0.00);

        // HuntMission - rating*1.5, bounty*2
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_BELOW_BOUNDARIES, RATING_AND_BOUNTY_BELOW_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.HuntMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(0D * 1.5, mission.getRating(), 0.00);
        Assert.assertEquals(0D * 2, mission.getBounty(), 0.00);

        // SurveillanceMission - rating * 0.25, bounty * 1.5
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_BELOW_BOUNDARIES, RATING_AND_BOUNTY_BELOW_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(0D * 0.25, mission.getRating(), 0.00);
        Assert.assertEquals(0D * 1.5, mission.getBounty(), 0.00);

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_IN_BOUNDARIES,
                RATING_AND_BOUNTY_BELOW_BOUNDARIES, RATING_AND_BOUNTY_BELOW_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_IN_BOUNDARIES, mission.getId());
        Assert.assertEquals(0D * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(0D * 1.25, mission.getBounty(), 0.00);
    }

    @Test
    public void testAboveBoundaries() {
        Mission mission;

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_ABOVE_BOUNDARIES,
                RATING_ABOVE_BOUNDARIES, BOUNTY_ABOVE_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_ABOVE_BOUNDARIES.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(100_000D * 1.25, mission.getBounty(), 0.00);

        // HuntMission - rating*1.5, bounty*2
        mission = missionControl.generateMission(ID_ABOVE_BOUNDARIES,
                RATING_ABOVE_BOUNDARIES, BOUNTY_ABOVE_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.HuntMission");
        Assert.assertEquals(ID_ABOVE_BOUNDARIES.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 1.5, mission.getRating(), 0.00);
        Assert.assertEquals(100_000D * 2, mission.getBounty(), 0.00);

        // SurveillanceMission - rating * 0.25, bounty * 1.5
        mission = missionControl.generateMission(ID_ABOVE_BOUNDARIES,
                RATING_ABOVE_BOUNDARIES, BOUNTY_ABOVE_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.SurveillanceMission");
        Assert.assertEquals(ID_ABOVE_BOUNDARIES.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.25, mission.getRating(), 0.00);
        Assert.assertEquals(100_000D * 1.5, mission.getBounty(), 0.00);

        // EscortMission - rating*0.75, bounty*1.25
        mission = missionControl.generateMission(ID_ABOVE_BOUNDARIES,
                RATING_ABOVE_BOUNDARIES, BOUNTY_ABOVE_BOUNDARIES);
        Assert.assertEquals(mission.getClass().getName(), "exams._2018_08_12_CallOfDuty.callofduty.domain.missions.EscortMission");
        Assert.assertEquals(ID_ABOVE_BOUNDARIES.substring(0, 8), mission.getId());
        Assert.assertEquals(100D * 0.75, mission.getRating(), 0.00);
        Assert.assertEquals(100_000D * 1.25, mission.getBounty(), 0.00);
    }
}