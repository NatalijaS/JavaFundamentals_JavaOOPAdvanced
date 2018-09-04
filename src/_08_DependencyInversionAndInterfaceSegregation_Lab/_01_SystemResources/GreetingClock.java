package _08_DependencyInversionAndInterfaceSegregation_Lab._01_SystemResources;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer output;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.output = writer;
    }

    public void greeting() {
        if (timeProvider.getHour() < 12) {
            output.println("Good morning...");
        } else if (timeProvider.getHour() < 18) {
            output.println("Good afternoon...");
        } else {
            output.println("Good evening...");
        }
    }
}
