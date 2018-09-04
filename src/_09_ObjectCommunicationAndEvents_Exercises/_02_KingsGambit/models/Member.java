package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.interfaces.Attackable;

public abstract class Member implements Attackable{

    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
