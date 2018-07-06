package _05_Reflection_Exercises._02_PrivateClassFiddling;

import _05_Reflection_Exercises._02_PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> blackBoxIntClass = BlackBoxInt.class;
        Constructor<?> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] inputArgs = line.split("_");

            Method method = blackBoxIntClass.getMethod(inputArgs[0], int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.valueOf(inputArgs[1]));
            // get and print field value
            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
    }

}

