import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Weapon> weapons = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("weapons.csv"));
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
                weapons.add(weapon);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}