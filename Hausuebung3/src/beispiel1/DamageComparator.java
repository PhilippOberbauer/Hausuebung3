package beispiel1;

import java.util.Comparator;

public class DamageComparator {
    private Comparator<Weapon> comparator;

    public Comparator<Weapon> getDamageComparator()
    {
        comparator = (w1, w2) -> w2.getDamage() - w1.getDamage();
        return comparator;
    }
}
