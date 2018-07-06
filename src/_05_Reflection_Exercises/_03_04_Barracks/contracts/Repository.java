package _05_Reflection_Exercises._03_04_Barracks.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String removeUnit(String unitType);
}
