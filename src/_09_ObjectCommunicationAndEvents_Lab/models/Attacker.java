package _09_ObjectCommunicationAndEvents_Lab.models;

import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;

public interface Attacker {

    void attack();

    void setTarget(ObservableTarget target);
}
