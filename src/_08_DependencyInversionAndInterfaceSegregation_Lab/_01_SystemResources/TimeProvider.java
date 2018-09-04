package _08_DependencyInversionAndInterfaceSegregation_Lab._01_SystemResources;

import java.time.LocalTime;

public interface TimeProvider {

    int getHour();

    class Implementation implements TimeProvider {

        LocalTime time;

        public Implementation(LocalTime time) {
            this.time = time;
        }

        public int getHour() {
            return this.time.getHour();
        }
    }
}
