package _04_EnumerationsAndAnnotations_Exercises._08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String player1 = reader.readLine();
        String player2 = reader.readLine();

        DeckOfCards firstDeck = new DeckOfCards();
        DeckOfCards secondDeck = new DeckOfCards();

        setCards(reader, firstDeck);
        setCards(reader, secondDeck);

        if (firstDeck.getHighestPoweredCard().getCardPower() > secondDeck.getHighestPoweredCard().getCardPower()) {
            System.out.println(player1 + " wins with " + firstDeck.getHighestPoweredCard().getRank().name() + " of " +
                    firstDeck.getHighestPoweredCard().getSuits().name() + ".");
        } else {
            System.out.println(player2 + " wins with " + secondDeck.getHighestPoweredCard().getRank().name() + " of " +
                    secondDeck.getHighestPoweredCard().getSuits().name() + ".");
        }
    }

    private static void setCards(BufferedReader reader, DeckOfCards deck) throws IOException {
        while (deck.getCardsSize() < 5) {
            String[] cardTokens = reader.readLine().split("\\s+");
            try {
                Rank rank = Rank.valueOf(cardTokens[0].toUpperCase());
                Suit suit = Suit.valueOf(cardTokens[2].toUpperCase());
                Card card = new Card(rank, suit);
                deck.addCard(card);
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            }
        }
    }
}
