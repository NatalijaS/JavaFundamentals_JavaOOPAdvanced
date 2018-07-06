package _04_EnumerationsAndAnnotations_Exercises._05_CardCompareTo;

public enum CardSuit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    public int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
