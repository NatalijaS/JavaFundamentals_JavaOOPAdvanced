package _04_EnumerationsAndAnnotations_Exercises._10_InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] inputArgs = line.split(";");
            String command = inputArgs[0];
            switch (command) {
                case "Create":
                    String weaponName = inputArgs[2];
                    String weaponType = inputArgs[1];
                    Weapon weapon = new Weapon(WeaponType.valueOf(weaponType), weaponName);
                    weapons.putIfAbsent(weaponName, weapon);
                    break;
                case "Add":
                    String weaponToAdd = inputArgs[1];
                    int socketIndex = Integer.parseInt(inputArgs[2]);
                    String gemType = inputArgs[3];
                    weapons.get(weaponToAdd).addGem(GemType.valueOf(gemType), socketIndex);
                    break;
                case "Remove":
                    String weaponToRemove = inputArgs[1];
                    int index = Integer.parseInt(inputArgs[2]);
                    weapons.get(weaponToRemove).removeGem(index);
                    break;
                default:
                    String weaponToPrint = inputArgs[1];
                    System.out.println(weapons.get(weaponToPrint));
                    break;
            }
        }
    }
}
