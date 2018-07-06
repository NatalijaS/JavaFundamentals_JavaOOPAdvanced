package _05_Reflection_Lab._01_Reflection;

import javafx.scene.effect.Reflection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> reflectionClass = Reflection.class;

        System.out.println("class " + reflectionClass.getSimpleName());
        System.out.println(reflectionClass.getSuperclass());
        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection ref = (Reflection) reflectionClass.newInstance();
        System.out.println(ref);
    }
}
