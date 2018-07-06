package _02_Generics_Exercises._04_GenericSwapMethodInteger;

import java.util.List;

public class Box<T> {
    private T field;

    public Box(T field) {
        this.field = field;
    }

    public static <T> void swap(int firstIndex, int secondIndex, List<T> list) {
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);
        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
    }

    @Override
    public String toString() {
        return this.field.getClass().getCanonicalName() + ": " + this.field;
    }

    T getField() {
        return field;
    }
}
