package _03_IteratorsAndComparators_Exercises._03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")) break;
            switch (input[0]) {
                case "Push":
                    for (int i = 1; i < input.length; i++) {
                        stack.push(Integer.valueOf(input[i].replace(",", "")));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("No elements");
                    }
                    break;
            }
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
