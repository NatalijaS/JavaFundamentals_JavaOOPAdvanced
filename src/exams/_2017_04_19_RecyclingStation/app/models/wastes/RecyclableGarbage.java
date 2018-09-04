package exams._2017_04_19_RecyclingStation.app.models.wastes;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends WasteImpl {

    public RecyclableGarbage(String name, double wightKg, double volumePerKg) {
        super(name, wightKg, volumePerKg);
    }
}
