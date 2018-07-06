package _04_EnumerationsAndAnnotations_Exercises._08_CardGame;

public enum Suit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    public int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
