package _02_Generics_Exercises._01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box box = new Box(reader.readLine());
            System.out.println(box.toString());
        }
    }
}
