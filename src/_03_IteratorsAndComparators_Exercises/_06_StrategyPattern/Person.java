package _03_IteratorsAndComparators_Exercises._06_StrategyPattern;

public class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
