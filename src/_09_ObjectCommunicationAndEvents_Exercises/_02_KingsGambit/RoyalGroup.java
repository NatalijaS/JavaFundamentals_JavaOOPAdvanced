package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.interfaces.AttackGroup;
import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models.Member;

import java.util.*;

public class RoyalGroup implements AttackGroup {

    private Map<String, Member> members;

    public RoyalGroup() {
        this.members = new HashMap<>();
    }


    @Override
    public void addMember(Member member) {
        this.members.putIfAbsent(member.getName(), member);
    }

    @Override
    public void attackGroup() {
        for (Member member : members.values()) {
            member.takeAttack();
        }
    }

    @Override
    public void killMember(String name) {
        this.members.remove(name);
    }
}
