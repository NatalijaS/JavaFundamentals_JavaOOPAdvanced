package _02_Generics_Exercises._06_GenericCountMethodDouble;

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
        List<Double> doubles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box box = new Box(Double.parseDouble(reader.readLine()));
            doubles.add((Double) box.getField());
        }
        Double element = Double.parseDouble(reader.readLine());
        System.out.println(Box.countGraeterValues(doubles, element));
    }
}
