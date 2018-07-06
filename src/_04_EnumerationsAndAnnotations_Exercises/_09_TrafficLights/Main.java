package _04_EnumerationsAndAnnotations_Exercises._09_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Traffic> trafficLightList = new ArrayList<>();
        String[] input = reader.readLine().split("\\s+");
        for (String anInput : input) {
            TrafficLight currentLight = TrafficLight.valueOf(anInput.toUpperCase());
            trafficLightList.add(new Traffic(currentLight));
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Traffic aTrafficLightList : trafficLightList) {
                sb.append(aTrafficLightList.next()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
