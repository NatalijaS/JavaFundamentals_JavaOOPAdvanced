package _09_ObjectCommunicationAndEvents_Lab._04_Observer;


public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}
