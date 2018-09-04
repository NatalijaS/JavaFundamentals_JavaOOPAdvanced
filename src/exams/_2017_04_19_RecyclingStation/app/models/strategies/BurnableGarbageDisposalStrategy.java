package exams._2017_04_19_RecyclingStation.app.models.strategies;

import exams._2017_04_19_RecyclingStation.app.models.WasteData;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

public class BurnableGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double volume = garbage.getVolumePerKg() * garbage.getWeight();
        double energyBalance = volume * 0.8;
        double capitalBalance = 0.0;

        return new WasteData(energyBalance, capitalBalance);
    }
}
