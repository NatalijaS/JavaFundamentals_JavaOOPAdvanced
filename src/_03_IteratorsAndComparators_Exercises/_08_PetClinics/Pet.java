package _03_IteratorsAndComparators_Exercises._08_PetClinics;

public class Pet {
    private String name;
    private int age;
    private String kind;

    Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
