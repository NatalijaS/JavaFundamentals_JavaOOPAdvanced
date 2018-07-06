package _03_IteratorsAndComparators_Lab._02_Library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    @SafeVarargs
    Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int index;

        LibIterator() {
            this.setIndex();
        }

        private void setIndex() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }
}
