package exams._2018_08_12_CallOfDuty.callofduty.core;

import exams._2018_08_12_CallOfDuty.callofduty.domain.agents.BaseAgent;
import exams._2018_08_12_CallOfDuty.callofduty.domain.agents.MasterAgent;
import exams._2018_08_12_CallOfDuty.callofduty.domain.agents.NoviceAgent;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Agent;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Mission;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.MissionControl;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.MissionManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {

    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private MissionControl missionControl;

    public MissionManagerImpl() {
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);

        agents.put(id, new NoviceAgent(id, name));

        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.valueOf(arguments.get(2));
        Double missionBounty = Double.valueOf(arguments.get(3));

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);
        this.agents.get(agentId).acceptMission(mission);
        this.missions.put(mission.getId(), mission);

        return String.format("Assigned %s - %s to Agent - %s",
                mission.getClass().getSimpleName().replace("Mission", " Mission"),
                missionId, this.agents.get(agentId).getName());
    }

    @Override
    @SuppressWarnings("unchecked")
    public String complete(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        String agentId = arguments.get(0);
        Agent agent = this.agents.get(agentId);

        agent.completeMissions();

        Class<?> agentClass = this.agents.get(agentId).getClass().getSuperclass();
        Field field = agentClass.getDeclaredField("completedMissions");
        field.setAccessible(true);
        List<Mission> completedMissions = (List<Mission>) field.get(agent);

        int completedMissionsCount = completedMissions.size();

        if (completedMissionsCount >= 3 && agent instanceof NoviceAgent) {
            Agent masterAgent = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());

            Field fieldAgent = BaseAgent.class.getDeclaredField("completedMissions");
            fieldAgent.setAccessible(true);
            fieldAgent.set(masterAgent, completedMissions);
            agents.remove(agent.getId());
            agents.put(masterAgent.getId(), masterAgent);
        }

        return String.format("Agent - %s:%s has completed all assigned missions.",
                agent.getName(), agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(0);

        Agent agent = this.agents.get(id);

        if(agent != null){
            return agent.toString();
        }else{
            return this.missions.get(id).toString();
        }
    }

    @Override
    public String over() {

        int noviceAgentsCount = 0;
        int masterAgentsCount = 0;
        int assignedMissionsCount = 0;
        int completedMissionsCount = 0;
        double ratingEarned = 0D;
        double bountyEarned = 0D;

        for (Agent agent : this.agents.values()) {
            if (agent instanceof MasterAgent) {
                masterAgentsCount++;
                bountyEarned += ((MasterAgent) agent).getBounty();
            } else {
                noviceAgentsCount++;
            }

            int assignedMissionsSize = getAgentMissions(agent, "missionsToComplete").size();
            int completedMissionsSize = getAgentMissions(agent, "completedMissions").size();

            assignedMissionsCount += assignedMissionsSize;
            assignedMissionsCount += completedMissionsSize;

            completedMissionsCount += completedMissionsSize;

            ratingEarned += agent.getRating();
        }

        return  String.format("Novice Agents: %d", noviceAgentsCount)
                + System.lineSeparator()
                + String.format("Master Agents: %d", masterAgentsCount)
                + System.lineSeparator()
                + String.format("Assigned Missions: %d", assignedMissionsCount)
                + System.lineSeparator()
                + String.format("Completed Missions: %d", completedMissionsCount)
                + System.lineSeparator()
                + String.format("Total Rating Given: %.2f", ratingEarned)
                + System.lineSeparator()
                + String.format("Total Bounty Given: $%.2f", bountyEarned);
    }

    @SuppressWarnings("unchecked")
    private List<Mission> getAgentMissions(Agent agent, String missionType) {
        List<Mission> missions;

        try {
            Field field = BaseAgent.class.getDeclaredField(missionType);
            field.setAccessible(true);
            missions = (List<Mission>) field.get(agent);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            missions = new ArrayList<>();
        }

        return missions;
    }
}
