package _04_EnumerationsAndAnnotations_Exercises._03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardRank cardRank = CardRank.valueOf(reader.readLine());
        CardSuit cardSuit = CardSuit.valueOf(reader.readLine());

        Card card = new Card(cardRank, cardSuit);
        System.out.println(card);
    }
}
