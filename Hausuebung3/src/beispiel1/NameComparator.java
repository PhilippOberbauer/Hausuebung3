package beispiel1;

import java.util.Comparator;
import java.util.List;

public class NameComparator {
    private Comparator<Weapon> comparator;

    public Comparator<Weapon> getNameComparator()
    {
        comparator = ((w1, w2) -> {
            if (w1.getCombatType().toString().equals(w2.getCombatType().toString()))
            {
                if (w1.getDamageType().toString().equals(w2.getDamageType().toString()))
                {
                    return w1.getName().compareTo(w2.getName());
                }
                else
                {
                    return w1.getDamageType().toString().compareTo(w2.getDamageType().toString());
                }
            }
            else
            {
                return w1.getCombatType().toString().compareTo(w2.getCombatType().toString());
            }
        });

        return comparator;
    }
}
