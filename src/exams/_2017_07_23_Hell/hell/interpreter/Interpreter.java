package exams._2017_07_23_Hell.hell.interpreter;


import exams._2017_07_23_Hell.hell.commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    Executable interpretCommand(String commandLine) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
