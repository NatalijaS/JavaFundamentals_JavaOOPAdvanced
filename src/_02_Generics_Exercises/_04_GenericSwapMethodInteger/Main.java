package _02_Generics_Exercises._04_GenericSwapMethodInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box box = new Box(Integer.parseInt(reader.readLine()));
            strings.add((Integer) box.getField());
        }
        String[] swapIndexes = reader.readLine().split(" ");
        Box.swap(Integer.parseInt(swapIndexes[0]), Integer.parseInt(swapIndexes[1]), strings);

        for (Integer string : strings) {
            System.out.println(new Box(string));
        }
    }
}
