package _01_InterfacesAndAbstraction_Exercises._05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Identity> citizens = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            if (tokens.length == 3) {
                citizens.add(new Person(tokens[2]));
            } else {
                citizens.add(new Person(tokens[1]));
            }
            line =reader.readLine();
        }

        String targetId = reader.readLine();
        for (Identity citizen : citizens) {
            if (citizen.getID().endsWith(targetId)) {
                System.out.println(citizen.getID());
            }
        }
    }
}