package exams._2017_07_23_Hell.hell.repository;

import java.util.Collection;

public interface Repository<T> {

    void add(T element);

    void remove(T element);

    T get(String elementName);

    Collection<T> getAll();

}
