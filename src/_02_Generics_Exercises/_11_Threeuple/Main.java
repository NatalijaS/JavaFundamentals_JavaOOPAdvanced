package _02_Generics_Exercises._11_Threeuple;

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

        Threeuple<String, String, String> threeuple1 = 
                new Threeuple(input1[0] + " " + input1[1], input1[2], input1[3]);
        Threeuple<String, Integer, Boolean> threeuple2 =
                new Threeuple(input2[0], Integer.valueOf(input2[1]), input2[2].equals("drunk"));
        Threeuple<String, Double, String> threeuple3 =
                new Threeuple(input3[0], Double.valueOf(input3[1]), input3[2]);

        System.out.println(threeuple1);
        System.out.println(threeuple2);
        System.out.println(threeuple3);
    }
}