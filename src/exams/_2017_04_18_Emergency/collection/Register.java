package exams._2017_04_18_Emergency.collection;

public interface Register<T> {

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    T peekEmergency();

    Integer count();

    Boolean isEmpty();
}
