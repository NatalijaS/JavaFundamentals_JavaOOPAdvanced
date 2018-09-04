package _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion;

import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.AdditionStrategy;
import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.DividingStrategy;
import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.MultiplyingStrategy;
import _09_ObjectCommunicationAndEvents_Exercises._03_DependencyInversion.strategies.SubtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new PrimitiveCalculator();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] parameters = line.split(" ");
            if (parameters[0].equals("mode")) {
                switch (parameters[1]) {
                    case "+":
                        calculator.changeStrategy(new AdditionStrategy());
                        break;
                    case "-":
                        calculator.changeStrategy(new SubtractionStrategy());
                        break;
                    case "*":
                        calculator.changeStrategy(new MultiplyingStrategy());
                        break;
                    case "/":
                        calculator.changeStrategy(new DividingStrategy());
                        break;
                }
            } else {
                int firstOperand = Integer.parseInt(parameters[0]);
                int secondOperand = Integer.parseInt(parameters[1]);
                System.out.println(calculator.performCalculation(firstOperand, secondOperand));
            }
        }
    }
}
