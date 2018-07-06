package _03_IteratorsAndComparators_Exercises._06_StrategyPattern.comparators;

import _03_IteratorsAndComparators_Exercises._06_StrategyPattern.Person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person person1, Person person2) {
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
