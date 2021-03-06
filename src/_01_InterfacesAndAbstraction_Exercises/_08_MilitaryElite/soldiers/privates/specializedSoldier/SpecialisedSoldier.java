package _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.soldiers.privates.specializedSoldier;

import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.interfaces.ISpecializedSoldier;
import _01_InterfacesAndAbstraction_Exercises._08_MilitaryElite.soldiers.privates.Private;

public abstract class SpecialisedSoldier extends Private implements ISpecializedSoldier {

    private String corps;

    SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!corps.equals("Airforces") && !corps.equals("Marines")) {
            throw new IllegalArgumentException("Wrong corps type!");
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Corps: %s\n", this.corps);
    }
}
