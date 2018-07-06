package _04_EnumerationsAndAnnotations_Exercises._12_InfernoInfinityOverrideTheCompareToMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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
                case "Compare":
                    Weapon weapon1 = weapons.get(inputArgs[1]);
                    Weapon weapon2 = weapons.get(inputArgs[2]);
                    DecimalFormat df = new DecimalFormat("0.0");
                    if (weapon1.compareTo(weapon2) < 0) {
                        System.out.println(weapon2 + " (Item Level: " + df.format(weapon2.getItemLevel()) + ")");
                    } else {
                        System.out.println(weapon1 + " (Item Level: " + df.format(weapon1.getItemLevel()) + ")");
                    }
                    break;
                default:
                    String weaponToPrint = inputArgs[1];
                    System.out.println(weapons.get(weaponToPrint));
                    break;
            }
        }
    }
}
