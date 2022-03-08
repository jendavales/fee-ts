package hw1;

public class FactorialCalculator {
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
