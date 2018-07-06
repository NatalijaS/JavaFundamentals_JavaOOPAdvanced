package _01_InterfacesAndAbstraction_Exercises._06_BirthdayCelebrations;

public class Person implements Identity {

    private String birthDate;

    public Person(String date) {
        this.birthDate = date;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
