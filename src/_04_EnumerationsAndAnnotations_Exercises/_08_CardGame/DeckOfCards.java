package _04_EnumerationsAndAnnotations_Exercises._08_CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class DeckOfCards {

    private List<Card> cards;

    DeckOfCards() {
        this.cards = new ArrayList<>();
    }

    void addCard(Card card) {
        if (this.cards.contains(card)) {
            System.out.println("Card is not in the deck.");
        }
        this.cards.add(card);
    }

    int getCardsSize() {
        return this.cards.size();
    }

    Card getHighestPoweredCard() {
        List<Card> cardsSorted = this.cards.stream().sorted().limit(1).collect(Collectors.toList());
        return cardsSorted.get(0);
    }
}
