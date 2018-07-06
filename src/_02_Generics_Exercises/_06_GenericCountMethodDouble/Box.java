package _02_Generics_Exercises._06_GenericCountMethodDouble;

import java.util.List;

public class Box<T extends Comparable<T>> {
    private T field;

    public Box(T field) {
        this.field = field;
    }

    static <T extends Comparable<T>> int countGraeterValues(List<T> list, T element) {
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return this.field.getClass().getCanonicalName() + ": " + this.field;
    }

    T getField() {
        return field;
    }
}
