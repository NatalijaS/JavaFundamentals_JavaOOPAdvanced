package _02_Generics_Exercises._09_CustomListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        CustomList list = new CustomList();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] commandArgs = line.split(" ");
            switch (commandArgs[0]) {
                case "Add":
                    list.add(commandArgs[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commandArgs[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commandArgs[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(commandArgs[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
            }
        }
    }
}
