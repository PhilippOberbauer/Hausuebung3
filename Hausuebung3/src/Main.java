import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Weapon> weaponList = new ArrayList<>();

            //1.1
            BufferedReader reader = new BufferedReader(new FileReader("weaponList.csv"));
            String line = reader.readLine();
            while (line != null)
            {
                line = reader.readLine();
                String[] arr = line.split(";");
                CombatType combatType = CombatType.valueOf(arr[1]);
                DamageType damageType = DamageType.valueOf(arr[2]);
                int damage = Integer.parseInt(arr[3]);
                int speed = Integer.parseInt(arr[4]);
                int strength = Integer.parseInt(arr[5]);
                int value = Integer.parseInt(arr[6]);
                Weapon weapon = new Weapon(arr[0], combatType, damageType, damage, speed, strength, value);
                weaponList.add(weapon);
            }
            //1.2
            DamageComparator damageComparator = new DamageComparator(weaponList);
            weaponList = damageComparator.sortDamage();

            //1.3
            NameComparator nameComparator = new NameComparator(weaponList);
            weaponList = nameComparator.sortName();

            //1.4
            Printable printable = (weapons) -> {
                for (Weapon w : weapons)
                {
                    System.out.println(w.toString());
                }
            };
            printable.print(weaponList);

            //1.5
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}