package _02_Generics_Exercises._02_GenericBoxOfInteger;

public class Box<T> {
    private T field;

    public Box(T field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field.getClass().getCanonicalName()+ ": " + this.field;
    }
}
