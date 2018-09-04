package _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion;

import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.Strategy;

public interface Calculator {

    void changeStrategy(Strategy strategy);

    int performCalculation(int firstOperand, int secondOperand);
}
