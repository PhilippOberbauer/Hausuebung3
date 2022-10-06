package beispiel4;

import java.util.stream.IntStream;

public class SquareNumbers {
    public int squareNumbers()
    {
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(x -> x % 2 == 1)
                                                                    .map(x -> x * x)
                                                                    .reduce(0, (x, y) -> x + y);
        return result;
    }
}
