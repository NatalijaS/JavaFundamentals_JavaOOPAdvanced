package _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion;

import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.AdditionStrategy;
import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.Strategy;

public class PrimitiveCalculator implements Calculator {

    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AdditionStrategy();
    }

    @Override
    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
