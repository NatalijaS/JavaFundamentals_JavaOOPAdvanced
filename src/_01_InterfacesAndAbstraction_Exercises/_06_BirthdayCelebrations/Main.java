package _01_InterfacesAndAbstraction_Exercises._06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Identity> peoplePets = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while(!line.equals("End")){
            String [] tokens = line.split(" ");
            if(tokens.length == 5){
                peoplePets.add(new Person(tokens[4]));
            }else{
                if(tokens[2].contains("/")){
                    peoplePets.add(new Pet(tokens[2]));
                }
            }
            line = reader.readLine();
        }

        String targetYear = reader.readLine();
        for (Identity personPet : peoplePets) {
            if(personPet.getBirthDate().endsWith(targetYear)){
                System.out.println(personPet.getBirthDate());
            }
        }
    }
}
