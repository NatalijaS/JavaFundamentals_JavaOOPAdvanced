package _09_ObjectCommunicationAndEvents_Exercises._06_MirrorImage.spells;

import java.util.ArrayList;
import java.util.List;

public class Reflection implements Spell {

    List<Integer> firstIdIndices;
    List<Integer> secondIdIndices;

    public Reflection() {
        this.firstIdIndices = new ArrayList<>();
        this.secondIdIndices = new ArrayList<>();
    }

    @Override
    public void cast() {

    }
}
