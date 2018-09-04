package exams._2017_04_19_RecyclingStation.app.models.wastes;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.annotations.Storable;

@Storable
public class StorableGarbage extends WasteImpl {

    public StorableGarbage(String name, double wightKg, double volumePerKg) {
        super(name, wightKg, volumePerKg);
    }
}
