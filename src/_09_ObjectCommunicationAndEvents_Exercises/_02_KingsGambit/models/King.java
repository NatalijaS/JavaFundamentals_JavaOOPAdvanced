package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models;

public class King extends Member {

    public King(String name) {
        super(name);
    }

    @Override
    public String takeAttack() {
        return String.format("King %s is under attack!", this.getName());
    }
}
