package _03_IteratorsAndComparators_Exercises._04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T extends Integer> implements Iterable<T> {
    private List<T> numbers;

     @SafeVarargs
     Lake(T... numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private List<T> indexes;
        private int index;

         Frog() {
            this.index = 0;
            this.setIndexes();
        }

        @Override
        public boolean hasNext() {
            return index < this.indexes.size();
        }

        @Override
        public T next() {
            return this.indexes.get(index++);
        }

        private void setIndexes() {
            this.indexes = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    this.indexes.add(numbers.get(i));
                }
            }

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 != 0) {
                    this.indexes.add(numbers.get(i));
                }
            }
        }
    }
}
