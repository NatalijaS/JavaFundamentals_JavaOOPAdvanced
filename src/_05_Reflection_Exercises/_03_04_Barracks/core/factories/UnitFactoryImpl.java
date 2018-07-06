package _05_Reflection_Exercises._03_04_Barracks.core.factories;

import _05_Reflection_Exercises._03_04_Barracks.contracts.Unit;
import _05_Reflection_Exercises._03_04_Barracks.contracts.UnitFactory;
import _05_Reflection_Exercises._03_04_Barracks.models.units.AbstractUnit;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"_03_04_Barracks.models.units.";

	@Override
	@SuppressWarnings("unchecked")
	public Unit createUnit(String unitType) throws ReflectiveOperationException {
		Class currentClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<AbstractUnit> constructor = currentClass.getDeclaredConstructor();
		constructor.setAccessible(true);

		return constructor.newInstance();
	}
}
