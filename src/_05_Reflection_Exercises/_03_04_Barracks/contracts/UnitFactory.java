package _05_Reflection_Exercises._03_04_Barracks.contracts;

import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ReflectiveOperationException;
}