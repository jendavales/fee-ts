package hw2;

import hw2.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void add_multipleAdditions_isCorrect() {
        Assertions.assertEquals(4, calculator.add(2, 2));
        Assertions.assertEquals(2, calculator.add(-1, 3));
        Assertions.assertEquals(1, calculator.add(1, 0));
    }

    @Test
    public void subtract_multipleSubtractions_isCorrect() {
        Assertions.assertEquals(3, calculator.subtract(4, 1));
        Assertions.assertEquals(4, calculator.subtract(3, -1));
        Assertions.assertEquals(3, calculator.subtract(3, 0));
    }

    @Test
    public void multiply_multipleMultiplications_isCorrect() {
        Assertions.assertEquals(4, calculator.multiply(2, 2));
        Assertions.assertEquals(-4, calculator.multiply(-2, 2));
        Assertions.assertEquals(4, calculator.multiply(-2, -2));
        Assertions.assertEquals(0, calculator.multiply(0, -2));
    }

    @Test
    public void divide_multipleDivisions_isCorrect() {
        Assertions.assertEquals(1, calculator.divide(2, 2));
        Assertions.assertEquals(-1, calculator.divide(2, -2));
        Assertions.assertEquals(1, calculator.divide(-2, -2));
        Assertions.assertEquals(0, calculator.divide(0, -2));
    }

    @Test
    public void divide_divisionByZero_throwsException() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> calculator.divide(1,0));
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }
}
