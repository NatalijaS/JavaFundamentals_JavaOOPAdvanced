package _05_Reflection_Exercises._03_04_Barracks.core.commands;

import _05_Reflection_Exercises._03_04_Barracks.contracts.Repository;
import _05_Reflection_Exercises._03_04_Barracks.contracts.Unit;
import _05_Reflection_Exercises._03_04_Barracks.contracts.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
