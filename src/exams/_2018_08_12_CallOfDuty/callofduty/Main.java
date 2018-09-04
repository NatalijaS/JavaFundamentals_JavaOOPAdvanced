package exams._2018_08_12_CallOfDuty.callofduty;


import exams._2018_08_12_CallOfDuty.callofduty.core.MissionManagerImpl;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.InputReader;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.MissionManager;
import exams._2018_08_12_CallOfDuty.callofduty.interfaces.OutputWriter;
import exams._2018_08_12_CallOfDuty.callofduty.io.ConsoleReader;
import exams._2018_08_12_CallOfDuty.callofduty.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        MissionManager missionManager = new MissionManagerImpl();

        String line;

        while(!"Over".equals(line = reader.readLine())){

            List<String> arguments = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String commandName = arguments.get(0);

            activateManager(missionManager, writer, commandName, arguments.subList(1, arguments.size()));
        }
        writer.println(missionManager.over());
    }

    private static void activateManager(MissionManager missionManager, OutputWriter writer,
                                        String commandName, List<String> arguments) throws NoSuchFieldException, IllegalAccessException {

        switch (commandName){
            case "Agent":
                writer.println(missionManager.agent(arguments));
                break;
            case "Request":
                writer.println(missionManager.request(arguments));
                break;
            case "Complete":
                writer.println(missionManager.complete(arguments));
                break;
            case "Status":
                writer.println(missionManager.status(arguments));
                break;
        }
    }
}




