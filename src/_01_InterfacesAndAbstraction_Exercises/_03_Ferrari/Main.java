package _01_InterfacesAndAbstraction_Exercises._03_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Ferrari ferrari = new Ferrari(name);
        System.out.println(String.format("%s/%s/%s/%s",
                ferrari.getModel(), ferrari.pushBrakes(), ferrari.pushGas(), ferrari.getDriver()));
    }
}
