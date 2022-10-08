package beispiel3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicatesMain {
    public static void main(String[] args) {
        Predicates predicates = new Predicates();

        IntPredicate isEven = predicates.isEven();
        System.out.println("isEven:");
        System.out.println("2: " + isEven.test(2));
        System.out.println("3: " + isEven.test(3));

        IntPredicate isPositive = predicates.isPositive();
        System.out.println("isPositive:");
        System.out.println("1: " + isPositive.test(1));
        System.out.println("-1: " + isPositive.test(-1));

        IntPredicate isZero = predicates.isZero();
        System.out.println("isZero:");
        System.out.println("0: " + isZero.test(0));
        System.out.println("1: " + isZero.test(1));

        Predicate<Integer> isNull = predicates.isNull();
        System.out.println("isNull:");
        System.out.println("1: " + isNull.test(1));
        System.out.println("null: " + isNull.test(null));

        Predicate<String> isShortWord = predicates.isShortWord();
        System.out.println("isShortWord:");
        System.out.println("yes: " + isShortWord.test("yes"));
        System.out.println("string: " + isShortWord.test("string"));

        System.out.println("isPositive and isEven");
        System.out.println("2: " + isPositive.and((IntPredicate) isEven).test(2));
        System.out.println("3: " + isPositive.and((IntPredicate) isEven).test(3));

        System.out.println("isPositive and negate isEven");
        System.out.println("3: " + isPositive.and((IntPredicate) isEven.negate()).test(3));
        System.out.println("4: " + isPositive.and((IntPredicate) isEven.negate()).test(4));
    }

}
