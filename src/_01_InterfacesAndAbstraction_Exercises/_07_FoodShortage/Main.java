package _01_InterfacesAndAbstraction_Exercises._07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Buyer> people = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n ; i++) {
            String line = reader.readLine();
            String [] tokens = line.split(" ");
            if (tokens.length == 4) {
                people.put(tokens[0], new Citizen(tokens[0]));
            } else {
                people.put(tokens[0], new Rebel(tokens[0]));
            }
        }

        String line = reader.readLine();
        while(!line.equals("End")){
            if(people.containsKey(line)){
                people.get(line).buyFood();
            }
            line = reader.readLine();
        }
        System.out.println(people.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
