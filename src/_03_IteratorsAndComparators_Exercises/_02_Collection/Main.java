package _03_IteratorsAndComparators_Exercises._02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator listyIterator = null;
        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            try {
                switch (tokens[0]) {
                    case "Create":
                        listyIterator = new ListyIterator(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "PrintAll":
                        listyIterator.printAll();
                        break;
                }
            }catch (IllegalStateException ise){
                System.out.println(ise.getMessage());
            }
        }
    }
}