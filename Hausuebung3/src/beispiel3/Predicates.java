package beispiel3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicates {
    public IntPredicate isEven()
    {
        final IntPredicate isEven = i -> i % 2 == 0;
        return isEven;
    }

    public IntPredicate isPositive()
    {
        final IntPredicate isPositive = i -> i > 0;
        return isPositive;
    }

    public IntPredicate isZero()
    {
        final IntPredicate isZero = i -> i == 0;
        return isZero;
    }

    public Predicate<Integer> isNull()
    {
        final Predicate<Integer> isNull = s -> s == null;
        return isNull;
    }

    public Predicate<String> isShortWord()
    {
        final Predicate<String> isShortWord = s -> s.length() < 4;
        return isShortWord;
    }
}
