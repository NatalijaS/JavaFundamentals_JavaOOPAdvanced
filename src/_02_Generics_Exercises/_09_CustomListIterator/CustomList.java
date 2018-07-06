package _02_Generics_Exercises._09_CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> list;

    CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    void remove(int index) {
        this.list.remove(index);
    }

    boolean contains(T element) {
        return this.list.contains(element);
    }

    void swap(int index1, int index2) {
        T firstElement = this.list.get(index1);
        T secondElement = this.list.get(index2);
        this.list.set(index1, secondElement);
        this.list.set(index2, firstElement);
    }

    int countGreaterThan(T element) {
        int count = 0;
        for (T aList : this.list) {
            if (aList.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    T getMax() {
        return Collections.max(this.list);
    }

    T getMin() {
        return Collections.min(this.list);
    }

    public List<T> getList() {
        return list;
    }

    void print() {
        for (T t : list) {
            System.out.println(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
