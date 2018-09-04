package _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies;

public class AdditionStrategy implements Strategy{

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
