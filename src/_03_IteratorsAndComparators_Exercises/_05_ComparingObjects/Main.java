package _03_IteratorsAndComparators_Exercises._05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split(" ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            personList.add(person);
            line = reader.readLine();
        }
        int nthPerson = Integer.parseInt(reader.readLine());
        if(nthPerson < personList.size()){
            int numberOfEqualPeople = 0;
            int numberOfNotEqualPeople = 0;
            int totalNumberOfPeople = personList.size();
            for (Person person : personList) {
                if(person.compareTo(personList.get(nthPerson)) == 0){
                    numberOfEqualPeople++;
                }else {
                    numberOfNotEqualPeople++;
                }
            }
            if(numberOfEqualPeople == 0){
                System.out.println("No matches");
            }
            System.out.println(String.format("%d %d %d", numberOfEqualPeople, numberOfNotEqualPeople, totalNumberOfPeople));
        }else{
            System.out.println("No matches");
        }
    }
}
