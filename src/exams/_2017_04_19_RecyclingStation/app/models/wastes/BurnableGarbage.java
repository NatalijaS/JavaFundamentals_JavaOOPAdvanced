package exams._2017_04_19_RecyclingStation.app.models.wastes;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.annotations.Burnable;

@Burnable
public class BurnableGarbage extends WasteImpl {

    public BurnableGarbage(String name, double wightKg, double volumePerKg) {
        super(name, wightKg, volumePerKg);
    }
}
