package lab1;
import java.util.function.Function;

public class GCDFunction implements Function<int[], Integer> {

    @Override
    public Integer apply(int[] numbers) {
        if (numbers.length != 2) {
            throw new IllegalArgumentException("Для вычисления НОД требуется два числа");
        }

        int a = numbers[0];
        int b = numbers[1];

        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}