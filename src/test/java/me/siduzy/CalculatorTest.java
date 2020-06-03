package me.siduzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testCalcWithInteger() {
        Calculator calc1 = new Calculator();
        Double output = calc1.calculate("( 1.0  + ( 2.0 * ( 3.00 + 5.00 ) ) )");
        Assertions.assertEquals(Double.valueOf(17), output);
    }
}
