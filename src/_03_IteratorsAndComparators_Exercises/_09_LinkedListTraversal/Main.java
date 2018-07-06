package _03_IteratorsAndComparators_Exercises._09_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedListTraversal<Integer> listTraversal = new LinkedListTraversalImpl<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split("\\s+");

            switch (lineArgs[0]) {
                case "Add":
                    listTraversal.add(Integer.parseInt(lineArgs[1]));
                    break;
                case "Remove":
                    listTraversal.remove(Integer.parseInt(lineArgs[1]));
                    break;
            }
        }

        System.out.println(listTraversal.getSize());
        listTraversal.forEach(element -> System.out.print(element + " "));
    }
}
