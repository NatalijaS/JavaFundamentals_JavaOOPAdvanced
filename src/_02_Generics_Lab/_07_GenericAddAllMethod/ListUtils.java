package _02_Generics_Lab._07_GenericAddAllMethod;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        checkInput(list);
        T min = list.get(0);
        for (T aList : list) {
            if (min.compareTo(aList) > 0) {
                min = aList;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        checkInput(list);
        T max = list.get(0);
        for (T aList : list) {
            if (max.compareTo(aList) < 0) {
                max = aList;
            }
        }
        return max;
    }

    private static <T> void checkInput(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> inner : source) {
            destination.addAll(inner);
        }
    }

    static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
