package beispiel1;

import java.util.List;

public class DamageComparator {
    private List<Weapon> list;

    public DamageComparator(List<Weapon> list) {
        this.list = list;
    }

    public List<Weapon> sortDamage()
    {
        list.sort((w1, w2) -> w1.getDamage() -w2.getDamage());
        return list;
    }
}
