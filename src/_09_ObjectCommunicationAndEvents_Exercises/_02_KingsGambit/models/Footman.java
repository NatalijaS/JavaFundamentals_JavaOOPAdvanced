package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.models;


public class Footman extends Member {

    public Footman(String name) {
        super(name);
    }

    @Override
    public String takeAttack() {
        return String.format("Footman %s is panicking!", this.getName());
    }
}
