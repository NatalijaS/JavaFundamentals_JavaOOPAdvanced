package _04_EnumerationsAndAnnotations_Exercises._09_TrafficLights;

public enum TrafficLight {
    RED("GREEN"),GREEN("YELLOW"), YELLOW("RED");

    String next;

    TrafficLight(String next) {
        this.next = next;
    }
    public String getNext(){
        return this.next;
    }
}
