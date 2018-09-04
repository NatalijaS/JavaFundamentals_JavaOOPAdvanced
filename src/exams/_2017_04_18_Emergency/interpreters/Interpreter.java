package exams._2017_04_18_Emergency.interpreters;

import exams._2017_04_18_Emergency.commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
