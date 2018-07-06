package _02_Generics_Exercises._05_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box box = new Box(reader.readLine());
            strings.add((String) box.getField());
        }
        String element = reader.readLine();
        System.out.println(Box.countGraeterValues(strings, element));
    }
}
