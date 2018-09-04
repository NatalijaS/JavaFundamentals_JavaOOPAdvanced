package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models;

public class RoyalGuard extends Member {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String takeAttack() {
        return String.format("Royal Guard %s is defending!", this.getName());
    }
}
