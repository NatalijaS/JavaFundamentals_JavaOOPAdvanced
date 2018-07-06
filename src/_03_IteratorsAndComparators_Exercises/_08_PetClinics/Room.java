package _03_IteratorsAndComparators_Exercises._08_PetClinics;

public class Room {
    private Pet pet;

    Room(Pet pet) {
        this.pet = pet;
    }

    Pet getPet() {
        return this.pet;
    }

    @Override
    public String toString() {
        return this.pet.toString();
    }
}
