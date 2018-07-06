package _04_EnumerationsAndAnnotations_Exercises._07_DeckOfCards;

public class DeckOfCards {

    private Rank[] ranks;
    private Suit[] suits;

    public DeckOfCards(Rank[] ranks, Suit[] suits) {
        this.ranks = ranks;
        this.suits = suits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                sb.append(rank.name()).append(" of ")
                        .append(suit.name()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
