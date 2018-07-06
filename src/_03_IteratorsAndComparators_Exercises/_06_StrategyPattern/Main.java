package _03_IteratorsAndComparators_Exercises._06_StrategyPattern;

import _03_IteratorsAndComparators_Exercises._06_StrategyPattern.comparators.PersonAgeComparator;
import _03_IteratorsAndComparators_Exercises._06_StrategyPattern.comparators.PersonNameComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            peopleByName.add(person);
            peopleByAge.add(person);
        }
        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}
