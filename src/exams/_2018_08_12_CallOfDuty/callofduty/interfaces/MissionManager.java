package exams._2018_08_12_CallOfDuty.callofduty.interfaces;

import java.util.List;

public interface MissionManager {

    String agent(List<String> arguments);

    String request(List<String> arguments);

    String complete(List<String> arguments) throws NoSuchFieldException, IllegalAccessException;

    String status(List<String> arguments);

    String over();
}
