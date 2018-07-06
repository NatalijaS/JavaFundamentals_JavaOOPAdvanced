package _02_Generics_Exercises._10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input1 = reader.readLine().split("\\s+");
        String[] input2 = reader.readLine().split("\\s+");
        String[] input3 = reader.readLine().split("\\s+");

        Tuple<String, String> tuple1 = new Tuple(input1[0] + " " + input1[1], input1[2]);
        Tuple<String, Integer> tuple2 = new Tuple(input2[0], Integer.valueOf(input2[1]));
        Tuple<Integer, Double> tuple3 = new Tuple(Integer.valueOf(input3[0]), Double.valueOf(input3[1]));

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
