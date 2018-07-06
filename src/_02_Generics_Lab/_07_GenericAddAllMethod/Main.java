package _02_Generics_Lab._07_GenericAddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> integers = new ArrayList<>();
            Collections.addAll(integers, 1, null, 2, 3);

            List<Double> doubles = new ArrayList<>();
            Collections.addAll(doubles, 1.3, 2.4, 3.3);

            List<Number> destination = new ArrayList<>();
            ListUtils.addAll(destination, integers);
            ListUtils.addAll(destination, doubles);

            System.out.println(destination);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
