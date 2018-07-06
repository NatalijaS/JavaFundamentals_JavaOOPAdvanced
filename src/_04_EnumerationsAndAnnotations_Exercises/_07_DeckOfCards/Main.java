package _04_EnumerationsAndAnnotations_Exercises._07_DeckOfCards;

public class Main {
    public static void main(String[] args) {
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();

        DeckOfCards deckOfCards = new DeckOfCards(ranks, suits);
        System.out.println(deckOfCards);
    }
}
