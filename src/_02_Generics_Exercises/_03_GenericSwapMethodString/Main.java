package _02_Generics_Exercises._03_GenericSwapMethodString;

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
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box box = new Box(reader.readLine());
            strings.add((String) box.getField());
        }
        String[] swapIndexes = reader.readLine().split(" ");
        Box.swap(Integer.parseInt(swapIndexes[0]), Integer.parseInt(swapIndexes[1]), strings);

        for (String string : strings) {
            System.out.println(new Box(string));
        }
    }
}
