package _02_Generics_Lab._04_ListUtilities;

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
}
