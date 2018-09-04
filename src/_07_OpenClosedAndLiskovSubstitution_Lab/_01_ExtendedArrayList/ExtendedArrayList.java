package _07_OpenClosedAndLiskovSubstitution_Lab._01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<E extends Comparable<E>> extends ArrayList<E> {

    public E max() {
        E max = null;
        Iterator<E> iterator = super.iterator();

        while (iterator.hasNext()) {
            E current = iterator.next();
            if (max == null || current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public E min() {
        E min = null;
        Iterator<E> iterator = super.iterator();

        while (iterator.hasNext()) {
            E current = iterator.next();
            if (min == null || current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }
}
