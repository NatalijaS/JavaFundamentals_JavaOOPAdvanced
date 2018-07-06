package _05_Reflection_Exercises._01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> richSoilLandClass = RichSoilLand.class;
        Field[] fields = richSoilLandClass.getDeclaredFields();

        String line;
        while (!"HARVEST".equals(line = reader.readLine())) {
            switch (line) {
                case "private":
                    Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.println("private " +
                                    field.getType().getSimpleName() + " " + field.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.println("protected" +
                                    field.getType().getSimpleName() + " " + field.getName()));
                    break;
                case "public":
                    Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.println("public" +
                                    field.getType().getSimpleName() + " " + field.getName()));
                    break;
                default:
                    Arrays.stream(fields).forEach(field ->
                            System.out.println(convertModifierToString(field.getModifiers())
                                    + field.getType().getSimpleName() + " " + field.getName()));
                    break;
            }
        }
    }

    private static String convertModifierToString(int modifiers) {
        switch (modifiers) {
            case 1:
                return "public";
            case 2:
                return "private";
            case 4:
                return "protected";
            default:
                return "";
        }
    }
}
