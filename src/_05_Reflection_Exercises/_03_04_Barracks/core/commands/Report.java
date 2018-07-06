package _05_Reflection_Exercises._03_04_Barracks.core.commands;

import _05_Reflection_Exercises._03_04_Barracks.contracts.Repository;
import _05_Reflection_Exercises._03_04_Barracks.contracts.UnitFactory;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        return this.getRepository().getStatistics();
    }
}
