package _04_EnumerationsAndAnnotations_Exercises._13_CreateCustomClassAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Class<?> weaponClass = Weapon.class;
        String line;
        while (!"END".equals(line = reader.readLine())) {
            switch (line) {
                case "Author":
                    System.out.println("Author: " + weaponClass.getAnnotation(CustomAnnotation.class).author());
                    break;
                case "Revision":
                    System.out.println("Revision: " + weaponClass.getAnnotation(CustomAnnotation.class).revision());
                    break;
                case "Description":
                    System.out.println("Class description: " + weaponClass.getAnnotation(CustomAnnotation.class).description());
                    break;
                case "Reviewers":
                    System.out.println("Reviewers: " + Arrays.toString(weaponClass.getAnnotation(CustomAnnotation.class)
                            .reviewers()).replace("]", "").replace("[", ""));
                    break;
            }
        }
    }
}
