package _02_Generics_Lab._06_GenericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> integers = new ArrayList<>();
            Collections.addAll(integers, 1, 2, 3);

            List<Double> doubles = new ArrayList<>();
            Collections.addAll(doubles, 1.3, 2.4, 3.3);

            List<List<? extends Number>> jagged = new ArrayList<>();
            Collections.addAll(jagged, integers, doubles);

            List<Number> dest = new ArrayList<>();
            ListUtils.flatten(dest, jagged);
            System.out.println(dest);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
