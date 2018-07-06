package _01_InterfacesAndAbstraction_Exercises._06_BirthdayCelebrations;

public class Pet implements Identity {

    private String birthDate;

    public Pet(String date) {
        this.birthDate = date;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}