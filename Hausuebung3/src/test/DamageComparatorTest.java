package test;

import beispiel1.CombatType;
import beispiel1.DamageComparator;
import beispiel1.DamageType;
import beispiel1.Weapon;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DamageComparatorTest {

    @Test
    public void getDamageComparator() {
        Weapon w1 = new Weapon("example", CombatType.MELEE, DamageType.BLUNT, 10, 4, 6, 1000);
        Weapon w2 = new Weapon("example", CombatType.MELEE, DamageType.BLUNT, 9, 4, 6, 1000);
        DamageComparator damageComparator = new DamageComparator();
        Assert.assertEquals(damageComparator.getDamageComparator().compare(w1, w2), -1);
        Assert.assertEquals(damageComparator.getDamageComparator().compare(w2, w1), 1);
    }
}