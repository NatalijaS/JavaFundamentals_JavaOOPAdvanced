package exams._2017_04_18_Emergency.commands;

import exams._2017_04_18_Emergency.annotations.InjectArgs;
import exams._2017_04_18_Emergency.core.ManagementSystem;
import exams._2017_04_18_Emergency.models.centers.EmergencyCenter;
import exams._2017_04_18_Emergency.models.centers.MedicalServiceCenter;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] data;
    private EmergencyCenter center;

    public RegisterMedicalServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String centerName = this.data[1];
        Integer amountOfEmergencies = Integer.valueOf(this.data[2]);

        this.center = new MedicalServiceCenter(centerName, amountOfEmergencies);
        return super.getManagementSystem().registerMedicalServiceCenter(this.center);
    }
}
