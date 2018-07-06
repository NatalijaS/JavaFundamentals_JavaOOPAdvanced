package _05_Reflection_Exercises._03_04_Barracks;

import _05_Reflection_Exercises._03_04_Barracks.contracts.Repository;
import _05_Reflection_Exercises._03_04_Barracks.contracts.Runnable;
import _05_Reflection_Exercises._03_04_Barracks.contracts.UnitFactory;
import _05_Reflection_Exercises._03_04_Barracks.core.Engine;
import _05_Reflection_Exercises._03_04_Barracks.core.factories.UnitFactoryImpl;
import _05_Reflection_Exercises._03_04_Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
