package _04_EnumerationsAndAnnotations_Lab._01_Weekdays;

public class Main {
    public static void main(String[] args) {

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Monday", "SoftUni");
        wc.addEntry("Friday", "SoftUni again");
        wc.addEntry("Sunday", "SoftUni again and again");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
