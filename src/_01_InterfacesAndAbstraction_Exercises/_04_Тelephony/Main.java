package _01_InterfacesAndAbstraction_Exercises._04_Тelephony;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Smartphone phone = new Smartphone();

        String[] numbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        for (String number : numbers) {
            System.out.println(phone.call(number));
        }

        for (String url : urls) {
            System.out.println(phone.browse(url));
        }
    }
}
