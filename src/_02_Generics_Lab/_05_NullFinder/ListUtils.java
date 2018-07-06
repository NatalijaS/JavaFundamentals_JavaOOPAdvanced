package _02_Generics_Lab._05_NullFinder;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        checkInput(list);
        T min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }
        return min;

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        checkInput(list);
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        return max;

    }

    private static <T> void checkInput(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }
    }

    static List<Integer> getNullIndices(List<?> list) {
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }
}
