package exams._2017_07_23_Hell.hell.commands;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

    String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
