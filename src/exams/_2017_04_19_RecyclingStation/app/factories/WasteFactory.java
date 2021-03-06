package exams._2017_04_19_RecyclingStation.app.factories;

import exams._2017_04_19_RecyclingStation.app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WasteFactory implements Factory<Waste> {

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
    }};

    private String wastePath;

    public WasteFactory(String wastePath) {
        this.wastePath = wastePath;
    }

    @Override
    public Waste create(String... args) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String type = args[args.length - 1];
        String className = wastePath + type + "Garbage";
        Class<?> wasteClass = Class.forName(className);

        Constructor<?> wasteConstructor = wasteClass.getDeclaredConstructors()[0];
        wasteConstructor.setAccessible(true);
        Class<?>[] wasteParameterTypes = wasteConstructor.getParameterTypes();

        Object[] wasteArguments = new Object[wasteParameterTypes.length];

        for (int i = 0; i < wasteParameterTypes.length; i++) {
            Class<?> parameterType = wasteParameterTypes[i].isPrimitive() ? getWrapper(wasteParameterTypes[i]) : wasteParameterTypes[i];
            Constructor<?> paramConstructor = parameterType.getConstructor(String.class);
            wasteArguments[i] = paramConstructor.newInstance(args[i]);
        }

        return (Waste) wasteConstructor.newInstance(wasteArguments);
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }
}
