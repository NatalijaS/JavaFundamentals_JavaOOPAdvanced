package _03_IteratorsAndComparators_Exercises._09_LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LinkedListTraversalImpl<E> implements LinkedListTraversal<E>, Iterable<E> {
    private List<E> items;

    LinkedListTraversalImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(E element) {
        this.items.add(element);
    }

    @Override
    public boolean remove(E element) {
        return this.items.remove(element);
    }

    @Override
    public int getSize() {
        return this.items.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private final class LinkedListIterator implements Iterator<E> {

        private int index;

        private LinkedListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public E next() {
            return items.get(this.index++);
        }
    }
}
