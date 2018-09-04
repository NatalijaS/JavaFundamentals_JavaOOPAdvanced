package exams._2017_04_19_RecyclingStation.tests.fakes;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.GarbageDisposalStrategy;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.ProcessingData;
import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

public class FakeStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        return null;
    }
}
