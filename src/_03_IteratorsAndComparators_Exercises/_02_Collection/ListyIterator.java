package _03_IteratorsAndComparators_Exercises._02_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ListyIterator<String> implements Iterable<String> {
    private int index;
    private List<String> collection;

    @SafeVarargs
    ListyIterator(String... collection) {
        this.collection = Arrays.asList(collection);
        this.index = 0;
    }

    boolean move() {
        if (this.collection.size() - 1 == this.index) {
            return false;
        }
        this.index++;
        return true;
    }

    boolean hasNext() {
        return this.collection.size() - 1 != this.index;
    }

    public void print() {
        if (this.collection.size() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.collection.get(this.index));
    }

    void printAll() {
        StringBuilder sb = new StringBuilder();
        for (String string : this) {
            sb.append(string).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIteratorClassIterator();
    }

    private final class ListIteratorClassIterator implements Iterator<String> {
        private int index;

        ListIteratorClassIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < collection.size();
        }

        @Override
        public String next() {
            return collection.get(this.index++);
        }
    }
}