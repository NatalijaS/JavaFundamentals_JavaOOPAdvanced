package _04_EnumerationsAndAnnotations_Exercises._08_CardGame;

public class Card implements Comparable<Card> {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    int getCardPower() {
        return (this.rank.getValue() + this.suit.getValue());
    }

    public Rank getRank() {
        return this.rank;
    }

    Suit getSuits() {
        return this.suit;
    }

    @Override
    public String toString() {
        return "Card name: " + this.rank + " of " + this.suit + "; Card power: " + getCardPower();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Card)) {
            return false;
        }

        Card card = (Card) obj;
        return card.getRank().equals(this.getRank()) &&
                card.getSuits() == this.getSuits();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(o.getCardPower(), this.getCardPower());
    }
}
