package exams._2018_08_12_CallOfDuty.callofduty.domain.agents;

public class NoviceAgent extends BaseAgent {

    public NoviceAgent(String id, String name) {
        super(id, name,0d);
    }

    @Override
    protected void earnBounty(Double bounty) {
    }
}
