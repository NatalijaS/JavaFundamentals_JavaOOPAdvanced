package _05_Reflection_Exercises._03_04_Barracks.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
