package _09_ObjectCommunicationAndEvents_Lab._03_Mediator;

import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;
import _09_ObjectCommunicationAndEvents_Lab.models.Attacker;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}
