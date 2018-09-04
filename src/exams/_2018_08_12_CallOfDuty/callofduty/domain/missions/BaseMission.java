package exams._2018_08_12_CallOfDuty.callofduty.domain.missions;

import exams._2018_08_12_CallOfDuty.callofduty.interfaces.Mission;

public abstract class BaseMission implements Mission{

    private String id;
    private Double rating;
    private Double bounty;
    private String status;

   protected BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.status = "Open";
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName().replace("Mission", " Mission") + String.format(" - %s", this.getId())
                + System.lineSeparator()
                + String.format("Status: %s", this.status)
                + System.lineSeparator()
                + String.format("Rating: %.2f", this.getRating())
                + System.lineSeparator()
                + String.format("Bounty: %.2f", this.getBounty());
    }
}
