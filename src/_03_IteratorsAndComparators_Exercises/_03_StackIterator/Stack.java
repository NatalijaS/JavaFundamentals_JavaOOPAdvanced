package _03_IteratorsAndComparators_Exercises._03_StackIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Stack<Integer> implements Iterable<Integer> {
    private List<Integer> elements;

    Stack() {
        this.setElements();
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(this.elements);
    }

    private void setElements() {
        this.elements = new ArrayList<>();
    }

    void push(Integer element) {
        this.elements.add(0, element);
    }


    Integer pop() {
        return this.elements.remove(0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer> {
        private int index;

        StackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public Integer next() {
            return elements.get(this.index++);
        }

    }
}
