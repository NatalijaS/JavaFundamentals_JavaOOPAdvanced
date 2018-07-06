package _04_EnumerationsAndAnnotations_Lab._04_CreateAnnotation;


import java.util.Arrays;

@Subject(categories = {"_04_EnumerationsAndAnnotations_Lab._04_CreateAnnotation.Main", "Test2"})
public class Main {
    public static void main(String[] args) {
        Class cl = Main.class;
        Subject subject = (Subject) cl.getAnnotation(Subject.class);
        System.out.println(Arrays.toString(subject.categories()));
    }
}

