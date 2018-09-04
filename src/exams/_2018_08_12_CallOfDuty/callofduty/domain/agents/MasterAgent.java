package exams._2018_08_12_CallOfDuty.callofduty.domain.agents;

import exams._2018_08_12_CallOfDuty.callofduty.interfaces.BountyAgent;

public class MasterAgent extends BaseAgent implements BountyAgent {

    private Double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = 0d;
    }

    @Override
    protected void earnBounty(Double bounty) {
        this.bounty += bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        String sb = System.lineSeparator() +
                String.format("Bounty Earned: $%.2f", this.getBounty());
        return super.toString() + sb;
    }
}
