package _03_IteratorsAndComparators_Exercises._07_EqualityLogic;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.name) != 0) {
            return this.name.compareTo(person.name);
        }
        return Integer.compare(this.age, person.age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;

        return person.name.equals(this.name) &&
                person.age == this.age;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.age;
        return result;
    }
}
