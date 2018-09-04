package exams._2017_07_23_Hell.hell.factories;

import java.lang.reflect.InvocationTargetException;

public interface Factory<T> {

    T create(String... args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException;
}
