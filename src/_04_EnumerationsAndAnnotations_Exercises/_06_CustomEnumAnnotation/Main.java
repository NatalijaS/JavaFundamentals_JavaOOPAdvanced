package _04_EnumerationsAndAnnotations_Exercises._06_CustomEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String ENUM_PACKAGE_PATH = "_04_EnumerationsAndAnnotations_Exercises._06_CustomEnumAnnotation.";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String enumType = reader.readLine();
        Class<?> enumClass = Class.forName(ENUM_PACKAGE_PATH + enumType);

        CustomInfo customInfo = enumClass.getAnnotation(CustomInfo.class);

        System.out.println("Type = " + customInfo.type() +
                ", Description = " + customInfo.description());
    }
}
