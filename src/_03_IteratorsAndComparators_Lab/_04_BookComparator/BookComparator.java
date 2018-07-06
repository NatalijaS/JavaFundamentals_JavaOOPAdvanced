package _03_IteratorsAndComparators_Lab._04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        if (b.getTitle().compareTo(a.getTitle()) == 0) {
            return Integer.compare(b.getYear(), a.getYear());
        }
        return b.getTitle().compareTo(a.getTitle());
    }
}
