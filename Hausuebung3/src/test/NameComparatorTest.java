package test;

import beispiel1.CombatType;
import beispiel1.DamageType;
import beispiel1.NameComparator;
import beispiel1.Weapon;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameComparatorTest {

    @Test
    public void getNameComparator() {
        Weapon w1 = new Weapon("firstExample", CombatType.MELEE, DamageType.BLUNT, 10, 4, 6, 1000);
        Weapon w2 = new Weapon("secondExample", CombatType.MELEE, DamageType.BLUNT, 9, 4, 6, 1000);
        NameComparator nameComparator = new NameComparator();
        Assert.assertEquals(nameComparator.getNameComparator().compare(w1, w2), -13);
        Assert.assertEquals(nameComparator.getNameComparator().compare(w2, w1), 13);
    }
}