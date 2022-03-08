package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FactorialCalculatorTest {

    @Test
    public void factorial_inputOne_returnOne() {
        Assertions.assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void factorial_inputZero_returnOne() {
        Assertions.assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void factorial_inputTwo_returnTwo() {
        Assertions.assertEquals(2, FactorialCalculator.factorial(2));
    }

    @Test
    public void factorial_inputFive_returnHundredTwenty() {
        Assertions.assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    public void factorial_inputThirteen_returnResult() {
        Assertions.assertEquals(6227020800L, FactorialCalculator.factorial(13));
    }
}
