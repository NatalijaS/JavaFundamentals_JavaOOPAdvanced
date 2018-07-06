package _02_Generics_Lab._04_ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> list1 = new ArrayList<>();
            list1.add(5);
            list1.add(6);
            list1.add(7);
            System.out.println(ListUtils.getMax(list1));
            System.out.println(ListUtils.getMin(list1));
            List<String> list2 = new ArrayList<>();
            System.out.println(ListUtils.getMax(list2));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
