package _02_Generics_Lab._05_NullFinder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            list.add(5);
            list.add(6);
            list.add(null);
            list.add(null);
            list.add(7);
            System.out.println(ListUtils.getNullIndices(list));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
