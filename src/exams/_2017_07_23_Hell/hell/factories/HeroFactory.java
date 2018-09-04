package exams._2017_07_23_Hell.hell.factories;

import exams._2017_07_23_Hell.hell.interfaces.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroFactory implements Factory<Hero> {

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
    }};

    private String heroesPath;

    public HeroFactory(String heroesPath) {
        this.heroesPath = heroesPath;
    }

    @Override
    public Hero create(String... data) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String heroType = data[data.length - 1];
        String className = heroesPath + heroType;
        Class<?> heroClass = Class.forName(className);

        Constructor<?> heroConstructor = heroClass.getDeclaredConstructors()[0];
        heroConstructor.setAccessible(true);
        Class<?>[] parameterTypes = heroConstructor.getParameterTypes();

        Object[] arguments = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i].isPrimitive() ?
                    this.getWrapper(parameterTypes[i]) :
                    parameterTypes[i];

            Constructor<?> parameterConstructor = parameterType.getConstructor(String.class);
            arguments[i] = parameterConstructor.newInstance(data[i]);
        }

        return (Hero) heroConstructor.newInstance(arguments);
    }

    private Class<?> getWrapper(Class<?> parameterType) {
        return this.mapper.get(parameterType);
    }
}
