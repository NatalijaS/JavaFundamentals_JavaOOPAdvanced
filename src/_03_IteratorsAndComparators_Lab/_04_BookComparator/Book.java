package _03_IteratorsAndComparators_Lab._04_BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    Integer getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }


    private void setAuthors(String... authors) {
        if(authors.length == 0){
            this.authors = new ArrayList<>();
        }else{
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }


    @Override
    public int compareTo(Book o) {
        if(this.getTitle().compareTo(o.getTitle()) == 0){
            if(this.getYear() > o.getYear()){
                return 1;
            }else if(this.getYear() < o.getYear()){
                return -1;
            }else{
                return 0;
            }
        }
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
