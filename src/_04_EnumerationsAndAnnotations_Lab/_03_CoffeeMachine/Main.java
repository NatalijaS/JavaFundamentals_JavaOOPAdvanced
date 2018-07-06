package _04_EnumerationsAndAnnotations_Lab._03_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")) break;

            try {
                coffeeMachine.insertCoin(input[0]);
            } catch (IllegalArgumentException e) {
                coffeeMachine.buyCoffee(input[0], input[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
