package exams._2017_04_19_RecyclingStation.app.models.wastes;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

public abstract class WasteImpl implements Waste{

    private String name;
    private double wightKg;
    private double volumePerKg;

    protected WasteImpl(String name, double wightKg, double volumePerKg) {
        this.name = name;
        this.wightKg = wightKg;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.wightKg;
    }
}
