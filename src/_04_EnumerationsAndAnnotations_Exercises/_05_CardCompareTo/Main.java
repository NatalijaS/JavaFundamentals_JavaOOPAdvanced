package _04_EnumerationsAndAnnotations_Exercises._05_CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardRank cardRank1 = CardRank.valueOf(reader.readLine());
        CardSuit cardSuit1 = CardSuit.valueOf(reader.readLine());

        CardRank cardRank2 = CardRank.valueOf(reader.readLine());
        CardSuit cardSuit2 = CardSuit.valueOf(reader.readLine());

        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(cardRank1, cardSuit1);
        Card card2 = new Card(cardRank2, cardSuit2);
        cards.add(card1);
        cards.add(card2);

        Collections.sort(cards);
        System.out.println(cards.get(0));
    }
}
