package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.interfaces;


import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models.Member;

public interface AttackGroup {

    void addMember(Member member);

    void attackGroup();

    void killMember(String name);
}
