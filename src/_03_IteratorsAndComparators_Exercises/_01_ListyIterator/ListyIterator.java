package _03_IteratorsAndComparators_Exercises._01_ListyIterator;

import java.util.*;

public class ListyIterator {
    private static final String COLLECTION_WITHOUT_ELEMENTS_EXCEPTION_MESSAGE = "Invalid Operation!";

    private int index;

    private List<String> collection;

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
            throw new CollectionWithoutElementsException(COLLECTION_WITHOUT_ELEMENTS_EXCEPTION_MESSAGE);
        }
        System.out.println(this.collection.get(this.index));
    }
}
