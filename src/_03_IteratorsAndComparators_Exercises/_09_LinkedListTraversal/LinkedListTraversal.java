package _03_IteratorsAndComparators_Exercises._09_LinkedListTraversal;

public interface LinkedListTraversal<E> extends Iterable<E> {
    void add(E element);

    boolean remove(E element);

    int getSize();
}
