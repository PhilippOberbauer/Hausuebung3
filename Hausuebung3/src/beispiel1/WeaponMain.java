package beispiel1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            List<Weapon> weaponList = new ArrayList<>();

            //1.1
            /*BufferedReader reader = new BufferedReader(new FileReader("weapons.csv"));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                String[] arr = line.split(";");
                CombatType combatType = CombatType.valueOf(arr[1]);
                DamageType damageType = DamageType.valueOf(arr[2]);
                int damage = Integer.parseInt(arr[3]);
                int speed = Integer.parseInt(arr[4]);
                int strength = Integer.parseInt(arr[5]);
                int value = Integer.parseInt(arr[6]);
                Weapon weapon = new Weapon(arr[0], combatType, damageType, damage, speed, strength, value);
                weaponList.add(weapon);
            }*/

            //1.7
            Stream<String> fileStream = Files.lines(Path.of("weapons.csv"));
            fileStream.forEach(s -> {
                String[] arr = s.split(";");
                if (!arr[0].equals("name"))
                {
                    CombatType combatType = CombatType.valueOf(arr[1]);
                    DamageType damageType = DamageType.valueOf(arr[2]);
                    int damage = Integer.parseInt(arr[3]);
                    int speed = Integer.parseInt(arr[4]);
                    int strength = Integer.parseInt(arr[5]);
                    int value = Integer.parseInt(arr[6]);
                    Weapon weapon = new Weapon(arr[0], combatType, damageType, damage, speed, strength, value);
                    weaponList.add(weapon);
                }
            });

            //1.2
            DamageComparator damageComparator = new DamageComparator();
            weaponList.sort(damageComparator.getDamageComparator());

            //1.3
            NameComparator nameComparator = new NameComparator();
            weaponList.sort(nameComparator.getNameComparator());

            //1.5
            Printable printable = weapons -> {
                for (Weapon w : weapons)
                {
                    System.out.println(w.toString());
                }
            };
            printable.print(weaponList);

            //1.6
            Printable printTable = weapons -> {
                int firstColumnWidth = "Name".length();
                int secondColumnWidth = "CombatType".length();
                int thirdColumnWidth = "DamageType".length();
                int fourthColumnWidth = "Damage".length();
                int fifthColumnWidth = "Speed".length();
                int sixthColumnWidth = "Strength".length();
                int seventhColumnWidth = "Value".length();

                for (Weapon w: weapons)
                {
                    if (firstColumnWidth < w.getName().length())
                    {
                        firstColumnWidth = w.getName().length();
                    }
                    if (secondColumnWidth < w.getCombatType().toString().length())
                    {
                        secondColumnWidth = w.getCombatType().toString().length();
                    }
                    if (thirdColumnWidth < w.getDamageType().toString().length())
                    {
                        thirdColumnWidth = w.getDamageType().toString().length();
                    }
                    if (fourthColumnWidth < String.valueOf(w.getDamage()).length())
                    {
                        fourthColumnWidth = String.valueOf(w.getDamage()).length();
                    }
                    if (fifthColumnWidth < String.valueOf(w.getSpeed()).length())
                    {
                        fifthColumnWidth = String.valueOf(w.getSpeed()).length();
                    }
                    if (sixthColumnWidth < String.valueOf(w.getStrength()).length())
                    {
                        sixthColumnWidth = String.valueOf(w.getStrength()).length();
                    }
                    if (seventhColumnWidth < String.valueOf(w.getValue()).length())
                    {
                        seventhColumnWidth = String.valueOf(w.getValue()).length();
                    }
                }

                System.out.println(String.format("| %-" + firstColumnWidth + "s | %-" + secondColumnWidth + "s | %-"
                                + thirdColumnWidth + "s | %-" + fourthColumnWidth + "s | %-" + fifthColumnWidth + "s | %-"
                                + sixthColumnWidth + "s | %-" + seventhColumnWidth + "s |"
                        , "Name", "CombatType", "DamageType", "Damage", "Speed", "Strength", "Value"));
                System.out.println("-----------------------------------------------------------------------------------");
                for (Weapon w: weapons)
                {
                    System.out.println(String.format("| %-" + firstColumnWidth + "s | %-" + secondColumnWidth + "s | %-"
                            + thirdColumnWidth + "s | %-" + fourthColumnWidth + "s | %-" + fifthColumnWidth + "s | %-"
                            + sixthColumnWidth + "s | %-" + seventhColumnWidth + "s |"
                            , w.getName(), w.getCombatType(), w.getDamageType(), w.getDamage(), w.getSpeed(),
                            w.getStrength(), w.getValue()));
                    System.out.println("-----------------------------------------------------------------------------------");
                }
            };

            System.out.println("Table: ");
            printTable.print(weaponList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}