package _04_EnumerationsAndAnnotations_Exercises._09_TrafficLights;

import java.util.Iterator;

public class Traffic implements Iterator<TrafficLight> {

    private TrafficLight currentLight;

    public Traffic(TrafficLight currentLight) {
        this.currentLight = currentLight;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public TrafficLight next() {
        this.currentLight = TrafficLight.valueOf(this.currentLight.getNext());
        return this.currentLight;
    }
}
